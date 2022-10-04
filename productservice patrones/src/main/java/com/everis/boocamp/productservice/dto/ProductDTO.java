package com.everis.boocamp.productservice.dto;


public class ProductDTO {
	
	
	private Long productId;
	
	private String channel;
	
	private String serverPort;

	public String getServerPort() {
		return serverPort;
	}

	public void setServerPort(String serverPort) {
		this.serverPort = serverPort;
	}

	public Long getProductId(Long id) {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public ProductDTO(Long productId, String channel) {

		this.productId = productId;
		this.channel = channel;
	}

	public ProductDTO() {
		super();
	}
	
	
	
	
	
	
	

	
	
	
	


}
