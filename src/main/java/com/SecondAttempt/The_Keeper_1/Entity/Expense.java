package com.SecondAttempt.The_Keeper_1.Entity;

import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Expense {
	public Expense(String category, String desc, int amt, int balance) {
		super();
		System.out.println(counter+" Inside arg const");
		this.id = counter++;
		this.setDate(LocalDate.now());
		this.setCategory(category);
		this.setDescription(desc);
		this.setAmt(amt);
		this.setBalance(balance);

	}
 	public Expense() {
 		// Optional: Initialize default values for fields here
// 		this.id = counter++;
// 		setDate(LocalDate.now());
// 		System.out.println(counter+" Inside e const");
 	}
	public static int counter=1;
 	@Id
 	public int id;

	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate today) {
		this.date = today;
	}
	public String getCategory() {
		return Category;
	}
	public void setCategory(String category) {
		Category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String desc) {
		description = desc;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public int getAmt() {
		return amt;
	}
	public void setAmt(int amt) {
		this.amt = amt;
	}
	public LocalDate date;
	public String Category;
 	public String description;
 	public int balance=0;
    public int amt;
    public boolean flag = true;
}
