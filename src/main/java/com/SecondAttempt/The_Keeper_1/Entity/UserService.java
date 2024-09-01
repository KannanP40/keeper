package com.SecondAttempt.The_Keeper_1.Entity;

import com.SecondAttempt.The_Keeper_1.DTO.UserDTO;
import com.SecondAttempt.The_Keeper_1.JDBC.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepo repo;
    public String check(UserDTO u){
        User user = repo.findByUserId(1);
        if(u.getUserName().equals(user.getUserName()) && u.getPassword().equals(user.getPassword())) return "";
        return "Wrong UserName or Password ";
    }
}
