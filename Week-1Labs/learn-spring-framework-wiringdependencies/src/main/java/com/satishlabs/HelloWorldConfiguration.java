package com.satishlabs;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;


//Eliminate verbosity in creating Java Beans
//Public accessor methods , constructor 
//equals , hashcode and toString are automatically created
//Released in JDK 16
record Person1(String name, int age) {};

record Person(String name, int age, Address address) {};

//Address - firstLine & city
record Address(String firstLine, String city) {};

@Configuration
public class HelloWorldConfiguration {
	
	@Bean
	public String name() {
		return "Satish";
	}
	
	@Bean
	public int age() {
		return 15;
	}
	
	@Bean
	public Person1 person1() {
		return new Person1("Test", 20);
	}
	
	@Bean
	public Person person() {
		var person = new Person("Ravi", 39,new Address("MG Street 2nd Cross", "Bangalore"));
		return person;
		
	}
	
	
	@Bean
	public Person person2MethodCall1() {
		var person = new Person(name(),age(),address());
		return person;
	}
	

	//No qualifying bean of type 'com.satishlabs.Address' available: 
	//expected single matching bean but found 2: address2,address3
	@Bean
	//@Primary
	public Person person3Parameters(String name,int age,Address address) {//name, age, address2
		var person = new Person(name,age,address);
		return person;
	}
	
	@Bean
	@Primary
	public Person person4Qualifier(String name,int age,@Qualifier("address3qualifier")Address address) {//name, age, address2
		var person = new Person(name,age,address);
		return person;
	}
	
	@Bean(name = "address2")
	@Primary
	public Address address() {
		var address = new Address("#572 15B", "Bangalore");
		return address;
	}
	
	@Bean(name = "address3")
	@Qualifier("address3qualifier")
	public Address address3() {
		var address = new Address("#346 TatiSilwai ", "Ranchi");
		return address;
	}
	
}
