package com.everis.bootcamp.priceservice.models;



import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;

@Entity
@Table(name = "Prices")
@Builder
public class Prices {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "CodeProduct")
	private String codeProduct;
	
	@Column(name = "Description")
	private String description;
	
	@Column(name = "Price")
	private BigDecimal price;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodeProduct() {
		return codeProduct;
	}

	public void setCodeProduct(String codeProduct) {
		this.codeProduct = codeProduct;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Prices(Integer id, String codeProduct, String description, BigDecimal price) {
		super();
		this.id = id;
		this.codeProduct = codeProduct;
		this.description = description;
		this.price = price;
	}

	public Prices() {
		super();
	}

	

	
	
}
