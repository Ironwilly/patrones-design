package com.everis.bootcamp.priceservice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class BaseService<T,ID,R extends JpaRepository <T,ID>> {
	
	
	  @Autowired
	    protected R repositorio;

	    public Optional<T> findById(ID id) {
	        return repositorio.findById(id);
	    }

	    public T save(T t) {
	        return repositorio.save(t);
	    }

	    public List<T> findAll(){
	        return repositorio.findAll();
	    }
	 

}
