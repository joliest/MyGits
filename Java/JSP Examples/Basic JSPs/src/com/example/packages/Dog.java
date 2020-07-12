package com.example.packages;

public class Dog {
	
	public Dog(String name) {
		this.setName(name);
	}

	private String name;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
