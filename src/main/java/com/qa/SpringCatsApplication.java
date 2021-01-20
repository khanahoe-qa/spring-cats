package com.qa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringCatsApplication {

	public static void main(String[] args) {
		ApplicationContext beanBag = SpringApplication.run(SpringCatsApplication.class, args);
		
		System.out.println(beanBag.getBean("getTime", String.class));
	}
}
