package com.microservices.vendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices.vendas.models.VendaItem;

public interface VendaItemRepository extends JpaRepository<VendaItem,Integer>{

}
