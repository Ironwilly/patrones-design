package com.everis.bootcamp.priceservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.everis.bootcamp.priceservice.dto.GetPricesDto;
import com.everis.bootcamp.priceservice.dto.PriceDtoConverter;
import com.everis.bootcamp.priceservice.models.Prices;
import com.everis.bootcamp.priceservice.services.PriceServicesI;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/prices")
public class PriceController {

	@Autowired
	private PriceServicesI priceServicesI;

	@Autowired
	private PriceDtoConverter priceDtoConverter;


	@CircuitBreaker(name = "priceservice-patrones",fallbackMethod = "fallBackCreateProduct")
	@PostMapping
	public ResponseEntity<GetPricesDto> create(@RequestBody Prices prices) throws Exception {

		return ResponseEntity.status(HttpStatus.CREATED).body(priceServicesI.create(prices));
	}

	@CircuitBreaker(name = "priceservice-patrones",fallbackMethod = "fallBackFindOne")
	@GetMapping("/{pricesId}")
	public ResponseEntity<GetPricesDto> findOne(@PathVariable Integer pricesId) {
		Optional<Prices> prices = priceServicesI.findById(pricesId);
		if (prices.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(priceDtoConverter.priceToGetPricesDto(prices.get()));

		} else {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).build();

		}

	}

	//@CircuitBreaker(name = "priceservice-patrones",fallbackMethod = "fallBackGetAll")
	@GetMapping("/all")
	public List<Prices> mostrarTodosPrecios() {

		return priceServicesI.getAllPrices();
	}
	
	private ResponseEntity<GetPricesDto> fallBackCreateProduct(@RequestBody Prices prices,RuntimeException e){
		return new ResponseEntity("El CB de fallBackCreateProduct " + prices,HttpStatus.OK );
	}
	
	private ResponseEntity<GetPricesDto> fallBackFindOne(@PathVariable Integer pricesId,RuntimeException e){
		return new ResponseEntity("El CB de fallBackFindOne" + pricesId,HttpStatus.OK);		
	}
	
	

}
