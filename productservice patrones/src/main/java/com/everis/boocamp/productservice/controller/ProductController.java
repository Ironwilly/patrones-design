package com.everis.boocamp.productservice.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.everis.boocamp.productservice.dto.ProductDTO;
import com.everis.boocamp.productservice.services.ProductServiceI;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/microservicio")
public class ProductController {

	
	
	private ProductServiceI productServiceI;
	
	public ProductController(ProductServiceI productServiceI) {
		this.productServiceI = productServiceI;
	}



	@CircuitBreaker(name ="product-service-patrones",fallbackMethod = "fallBackGetProduct" )
	@GetMapping("{id}")
	public ProductDTO getProduct(@PathVariable Long id) {
		return productServiceI.getProductId(id);
	}
	
	@CircuitBreaker(name = "product-service-patrones",fallbackMethod = "fallBackPostProduct")
	@PostMapping("{id}")
	public ProductDTO postProduct(@PathVariable Long id) {
		return productServiceI.postProductId(id);
	}
	

	
	
	private ProductDTO fallBackGetProduct (@PathVariable Long id,RuntimeException e) {
		return new ProductDTO(id,"El producto del metodo get con id " + id + "es");
	}
	
	
	private ProductDTO fallBackPostProduct (@PathVariable Long id,RuntimeException e) {
		return new ProductDTO(id,"El producto del metodo post con id " + id + "es");
	}

	
	
	
	
	

}
