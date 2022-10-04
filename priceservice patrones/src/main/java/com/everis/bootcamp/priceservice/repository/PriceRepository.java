package com.everis.bootcamp.priceservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.everis.bootcamp.priceservice.models.Prices;

public interface PriceRepository extends JpaRepository<Prices, Integer> {

}
