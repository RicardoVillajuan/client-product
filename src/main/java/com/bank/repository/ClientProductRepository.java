package com.bank.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.bank.entity.ClientProduct;


public interface ClientProductRepository extends ReactiveMongoRepository<ClientProduct, String>{

}
