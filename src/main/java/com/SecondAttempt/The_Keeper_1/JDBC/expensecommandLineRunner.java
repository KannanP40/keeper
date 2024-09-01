package com.SecondAttempt.The_Keeper_1.JDBC;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.SecondAttempt.The_Keeper_1.Entity.Expense;

@Component
public class expensecommandLineRunner implements CommandLineRunner{

	@Autowired
	Repo r;
	@Override
	public void run(String... args) throws Exception {
		Expense e = new Expense("Income","Salaryy",10000,10000);
		r.save(e);
	}
}
