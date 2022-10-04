package com.everis.bootcamp.priceservice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.bootcamp.priceservice.dto.GetPricesDto;
import com.everis.bootcamp.priceservice.dto.PriceDtoConverter;
import com.everis.bootcamp.priceservice.models.Prices;
import com.everis.bootcamp.priceservice.repository.PriceRepository;

@Service("pricesService")
public class PriceServicesImpl extends BaseService<Prices, Integer, PriceRepository>implements PriceServicesI {
	
	@Autowired
	private PriceRepository priceRepository;
	
	
	
	@Autowired
	private PriceDtoConverter priceDtoConverter;

	@Override
	public GetPricesDto create(Prices prices) {

		Prices result = priceRepository.save(Prices.builder()
				
				.id(prices.getId())
				.codeProduct(prices.getCodeProduct())
				.description(prices.getDescription())
				.price(prices.getPrice())
				.build()
				
				);
				
		return priceDtoConverter.priceToGetPricesDto(result);
		
	}

	
	
	@Override
	public Optional<Prices> findById(Integer id) {
		Optional<Prices> buscarPrecioPorId = repositorio.findById(id);
		return buscarPrecioPorId;
	}

	@Override
	public List<Prices> getAllPrices() {
		return repositorio.findAll();
	}

}
