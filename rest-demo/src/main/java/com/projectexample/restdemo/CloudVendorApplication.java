package com.projectexample.restdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ComponentScan(basePackages ={})
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
//@EnableJpaRepositories("CloudVendorRepository")
public class CloudVendorApplication {

	public static void main(String[] args) {

		SpringApplication.run(CloudVendorApplication.class, args);
	}
	@Bean
		public  RestTemplate restTemplate()
		{
			return new RestTemplate();
		}



}
