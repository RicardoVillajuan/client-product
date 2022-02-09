package com.bank.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.bank.entity.ClientProduct;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface ClientProductRepository extends ReactiveMongoRepository<ClientProduct, String>{
	
	
	
	Flux<ClientProduct> findByClient(String idclient);
	
}
