package com.bank.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bank.model.Client;
import com.bank.model.Product;
import com.bank.model.Cuenta;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "clientproduct")
public class ClientProduct {
	
	@Id
	private String id;
	private Mono<Client> client;
	
	private Mono<Product> product;

	
	
	
	
}
