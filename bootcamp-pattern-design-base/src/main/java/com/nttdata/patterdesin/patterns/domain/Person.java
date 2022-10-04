package com.nttdata.patterdesin.patterns.domain;

import com.nttdata.patterdesin.patterns.decorator.PersonInterface;

import lombok.Builder;

@Builder
public class Person implements PersonInterface {
	
	
	public final static Person INSTANCES = new Person ();

	public Person() {
		super();
	
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getAge() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setAge(int age) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	
	
	/*
    private String name;

    private int age;

    public Person() {
        super();
    }

    public Person(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        return this.name;
    }

*/
	
	
}
