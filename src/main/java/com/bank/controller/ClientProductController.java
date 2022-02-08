package com.bank.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bank.entity.ClientProduct;
import com.bank.model.Client;
import com.bank.model.Product;
import com.bank.service.IClientProduct;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/clientsproducts")
public class ClientProductController {
	
	private final IClientProduct clientProductService;
	
	
	@GetMapping("/list")
	public Flux<Product> findById(){
		
		
		
		return clientProductService.findProductAll();
	}
	
	/*@GetMapping("/save")
	public Mono<ClientProduct> findById(@RequestParam("idclient") String client,@RequestParam("idproduct") String idproduct){
		
		
		Flux<Product> objProduct=clientProductService.findByIdProduct(idproduct);
		Mono<Client> objClient=clientProductService.findByClient(client);
		
		ClientProduct objClientProduct=new ClientProduct();
		objClientProduct.setClient(objClient);
		objClientProduct.setProduct(objProduct);
		
		clientProductService.save(objClientProduct);
		
		return clientProductService.save(objClientProduct);
	}*/
	
}
