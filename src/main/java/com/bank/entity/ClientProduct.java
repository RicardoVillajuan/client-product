package com.bank.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bank.model.Client;
import com.bank.model.Product;

import lombok.Data;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Data
@Document(collection = "clientproduct")
public class ClientProduct {
	
	@Id
	private String id;
	private Mono<Client> client;
	private Flux<Product> product;
	
	
}
