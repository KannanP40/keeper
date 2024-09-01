package com.SecondAttempt.The_Keeper_1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.SecondAttempt.The_Keeper_1.Entity.ExpenseService;
import com.SecondAttempt.The_Keeper_1.JDBC.Repo;

import jakarta.persistence.EntityManagerFactory;

@SpringBootApplication
public class TheKeeper1Application {
	public static void main(String[] args) {
		SpringApplication.run(TheKeeper1Application.class, args);
	}

}
