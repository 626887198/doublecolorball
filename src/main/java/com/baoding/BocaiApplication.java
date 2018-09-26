package com.baoding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class BocaiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BocaiApplication.class, args);
	}
}
