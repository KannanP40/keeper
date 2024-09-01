package com.SecondAttempt.The_Keeper_1.Entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SecondAttempt.The_Keeper_1.JDBC.Repo;

@Service
public class ExpenseService {
	
	@Autowired
	Repo r;
	
	public void addToDb(Expense e) {
		Expense expense = (r.findById(r.findIdByCustomFlag(true))).get();
        expense.flag = false;
        e.setBalance(expense.getBalance()+e.getAmt());
		r.save(new Expense(e.getCategory(),e.getDescription(),e.getAmt(),expense.getBalance()+e.getAmt()));	
	}

	public List<Expense> TotalData() {
		List<Expense> expenses = r.findAll();
		return expenses;
	}

	public Map<String, Integer> calculateIncome() {
		// TODO Auto-generated method stub
		Map<String, Integer> map = new HashMap<>();
		map.put("Jan",100000);
		return map;
	}

	public Map<String, Integer> calculateExpense() {
		// TODO Auto-generated method stub
		Map<String, Integer> map = new HashMap<>();
		map.put("Jan",10000);
		return map;
	}
	
}
