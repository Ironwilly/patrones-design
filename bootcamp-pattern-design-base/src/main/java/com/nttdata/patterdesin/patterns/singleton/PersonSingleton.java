package com.nttdata.patterdesin.patterns.singleton;

import com.nttdata.patterdesin.patterns.domain.Person;

import lombok.Builder;

@Builder
public class PersonSingleton {
	
	public final static Person INSTANCE = new Person();
	
	private PersonSingleton() {
		super();
	}
	
//	public static Person getInstance() {
//		if (INSTANCE == null) {
//			INSTANCE = new Person();
//		}
//		return INSTANCE;		
//	}
}
