package com.gugwexample.demo1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration

public class MyConfig {
	@Bean
	IBookService bookService()
	{
		return new BookService();
	}
}
