package com.everis.bootcamp.priceservice.services;

import java.util.List;
import java.util.Optional;

import com.everis.bootcamp.priceservice.dto.GetPricesDto;
import com.everis.bootcamp.priceservice.models.Prices;

public interface PriceServicesI {
	
	public  GetPricesDto create(Prices prices); 
		
	public Optional<Prices> findById(Integer id);
	
	public List<Prices> getAllPrices();
	

}
