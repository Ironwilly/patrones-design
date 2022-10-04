package com.everis.bootcamp.priceservice.dto;

import org.springframework.stereotype.Component;

import com.everis.bootcamp.priceservice.models.Prices;

@Component
public class PriceDtoConverter {
	
	public GetPricesDto priceToGetPricesDto(Prices prices) {
		
		return GetPricesDto.builder()
				.id(prices.getId())
				.codeProduct(prices.getCodeProduct())
				.description(prices.getDescription())
				.price(prices.getPrice())
				.build();
	}

}
