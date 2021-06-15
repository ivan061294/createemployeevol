package com.service.employe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.service.employe.utils.MyDataAcces;


@SpringBootApplication
public class MainemployeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainemployeeApplication.class, args);
		MyDataAcces conect = new MyDataAcces();

	}

}
