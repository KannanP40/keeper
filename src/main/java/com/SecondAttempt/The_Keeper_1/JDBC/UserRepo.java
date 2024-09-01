package com.SecondAttempt.The_Keeper_1.JDBC;

import com.SecondAttempt.The_Keeper_1.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {

    User findByUserId(int i);
}
