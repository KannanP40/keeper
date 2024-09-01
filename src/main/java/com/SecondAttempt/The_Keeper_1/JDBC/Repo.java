package com.SecondAttempt.The_Keeper_1.JDBC;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.SecondAttempt.The_Keeper_1.Entity.Expense;

@Repository
public interface Repo extends JpaRepository<Expense,Integer>{
    @Query(value = "select balance from Expense where flag = :flagValue")
    public int findBalanceByCustomFlag(boolean flagValue);
    
    @Query(value= "select id from Expense where flag = :flagValue")
    public int findIdByCustomFlag(boolean flagValue);

}
