package com.microservices.vendas.services;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.vendas.clients.PessoasClient;
import com.microservices.vendas.clients.ProdutosClient;
import com.microservices.vendas.dtos.AtualizarEstoqueDTO;
import com.microservices.vendas.dtos.ClienteDTO;
import com.microservices.vendas.dtos.ProdutoDTO;
import com.microservices.vendas.models.Venda;
import com.microservices.vendas.repositories.VendaRepository;

import jakarta.transaction.Transactional;

@Service
public class VendaService {
	
	@Autowired
	private PessoasClient pessoa;
	
	@Autowired
	private ProdutosClient produtosClient;
	
	@Autowired
	private VendaRepository vendaRepository;
	
	@Transactional
	public Venda realizarVenda(Venda venda) {
		
		List<AtualizarEstoqueDTO> atualizarEstoqueProdutos = new ArrayList<>();
		
		ClienteDTO cliente = pessoa.buscarCliente(venda.getClienteDocumento());	
		if(cliente == null) {
			throw new RuntimeException("Cliente não existe no serviço de Pessoas");
		}	
		venda.setClienteDocumento(cliente.getDocumento());
		
		venda.getItens().forEach(item ->{	
			ProdutoDTO produto = produtosClient.buscarProduto(item.getCodigoBarras());
			if(produto == null) {
				throw new RuntimeException("Produto não existe no serviço Estoque");
			}		
			item.setCodigoBarras(produto.getCodigoBarras());	
			item.setPrecoVenda(produto.getPrecoVenda());
			atualizarEstoqueProdutos.add(
					new AtualizarEstoqueDTO(produto,
							(item.getQuantidade()*(-1)))//envia valor negativo /saida.
					);
		});
				
		venda.getItens().forEach(item -> {
			item.setVenda(venda);
		});
		
		venda.setValorTotal(venda.calcularValorTotal());
		
		Venda vendaSalva = vendaRepository.save(venda);

		produtosClient.atualizarQuantidade(atualizarEstoqueProdutos);
		
		return vendaSalva;
	}
	
	public List<Venda> buscarVendas(){
		return vendaRepository.findAll();
	}
	

}
