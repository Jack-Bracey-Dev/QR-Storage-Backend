package com.jbt.qrstorage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.reactive.config.EnableWebFlux;

@ComponentScan(basePackages = {"com.jbt.qrstorage"})
@EnableWebFlux
@SpringBootApplication

public class Runtime {

	public static void main(String[] args) {
		SpringApplication.run(Runtime.class, args);
	}

}
