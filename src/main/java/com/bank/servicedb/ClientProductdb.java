package com.bank.servicedb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bank.entity.ClientProduct;

import com.bank.model.Client;
import com.bank.model.Product;
import com.bank.repository.ClientProductRepository;
import com.bank.service.IClientProduct;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class ClientProductdb implements IClientProduct{
	
	private final ClientProductRepository repoClientProduct;
	
	@Autowired
	RestTemplate restTemplate;
	
	
	@Override
	public Mono<ClientProduct> save(ClientProduct clientproduct) {
		// TODO Auto-generated method stub
		
		
		return repoClientProduct.save(clientproduct);
	}

	@Override
	public void deleteById(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Flux<Product> findProductAll() {
		// TODO Auto-generated method stub
		return restTemplate.getForObject("http://localhost:8081/product/listproduct",Flux.class);
	}

	

	

	
	
	
	
	
	/*@Override
	public Flux<Product> findByIdProduct(String idproduct) {
		// TODO Auto-generated method stub
		Mono<Product> objProduct=restTemplate.getForObject("http://localhost:8081/product/findbyid/"+idproduct, Mono.class);
		Flux<Product> objFlux=objProduct.flux();
		return objFlux;
	}

	@Override
	public Mono<Client> findByClient(String client) {
		// TODO Auto-generated method stub
		Mono<Client> objClient=restTemplate.getForObject("http://localhost:8082/clients/findbyid/"+client, Mono.class);
		return objClient;
	}*/

	

	
}
