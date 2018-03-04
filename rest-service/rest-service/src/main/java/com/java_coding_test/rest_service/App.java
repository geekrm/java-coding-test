package com.java_coding_test.rest_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.java_coding_test.rest_service")
public class App 
{
	
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }
}
