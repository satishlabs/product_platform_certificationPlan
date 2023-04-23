package com.satishlabs;

import java.io.Serializable;

class Pojo{
	private String text;
	private int number;
	@Override
	public String toString() {
		return text + "," + number;
	}	
}
						//3. implements serialization 
class JavaBean implements Serializable{//EJB
	
	//1. public no-arg constructor
	public JavaBean() {
		
	}
	
	//2. getters & setters
	private String text;
	private int number;
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
	
}

public class SpringBeanVsJavaBean {
	public static void main(String[] args) {
		Pojo pojo = new Pojo();
		System.out.println(pojo);
	}
}
