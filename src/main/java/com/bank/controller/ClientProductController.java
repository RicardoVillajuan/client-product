package com.bank.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
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
	
	private static final Logger log=LoggerFactory.getLogger(SpringBootApplication.class);
	
	private final IClientProduct clientProductService;
	
	
	@GetMapping("")
	public Flux<ClientProduct> findByAll(){
		

		return clientProductService.findAll();
	}
	
	@DeleteMapping("/{id}")
	void deleteProduct(@PathVariable String id){

		clientProductService.deleteById(id);
	}
	
	@PostMapping("/save")
	public Mono<ClientProduct> save(@RequestParam("idclient") String idclient,
			@RequestParam("typeclient") String typeclient,
			@RequestParam("typeproduct") String typeproduct, @RequestParam("idproduct") String idproduct){
		
			Client objClient= new Client(idclient,typeclient);
			Mono<Client> objClients=Mono.just(objClient);
			
			Product objProduct=new Product(idproduct,typeproduct);
		
			Mono<Product> objProducts=Mono.just(objProduct);
			
			ClientProduct objClientProduct=new ClientProduct();
			objClientProduct.setClient(objClients);
			objClientProduct.setProduct(objProducts);
			
			//
			/*Flux<ClientProduct> AllClientProduct= clientProductService.findAll();
			AllClientProduct.filter(e->{
					e.getClient().filter(o->{
						
						return o.getId().equals(idclient);
					});
				return true;
			})
			.map(e->{
				
			})
			.subscribe();*/
			
			
			return clientProductService.save(objClientProduct);
		
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
