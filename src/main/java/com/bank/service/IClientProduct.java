package com.bank.service;

import com.bank.entity.ClientProduct;
import com.bank.model.Client;
import com.bank.model.Product;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IClientProduct {

	Mono<ClientProduct> save(ClientProduct clientproduct); 
	
	void deleteById(String id);
	
	
	
	Flux<ClientProduct> findAll();
}
