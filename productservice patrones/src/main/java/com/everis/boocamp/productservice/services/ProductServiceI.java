package com.everis.boocamp.productservice.services;

import com.everis.boocamp.productservice.dto.ProductDTO;

public interface ProductServiceI {
	
	public ProductDTO getProductId(Long id);
	
	public ProductDTO postProductId(Long id);
	


}
