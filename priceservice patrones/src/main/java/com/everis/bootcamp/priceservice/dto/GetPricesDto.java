package com.everis.bootcamp.priceservice.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetPricesDto {
	
	private Integer id;

	private String codeProduct;
	
	private String description;
	
	private BigDecimal price;

}
