package com.gugwexample.demo1;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


public class BookService implements IBookService{
	public BookService()
	{
		System.out.println("bookservice construct");
	}

	@Override
	public void save() {
		System.out.println("bookservice save");
	}
	@Override
	public double price() {
		System.out.println("bookservice price");
		return 100;
	}

	public double calcPrice(double price) {
		System.out.println("bookservice calcPrice");
		return price*0.3;
	}
	

	@PostConstruct
	public void afterPropertiesSet() throws Exception {
		System.out.println("bookservice init");
	}

	@PreDestroy
	public void destroy() throws Exception {
		System.out.println("bookservice destroy");
	}

	
	
}
