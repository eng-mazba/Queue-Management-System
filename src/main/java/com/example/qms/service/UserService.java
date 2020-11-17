package com.example.qms.service;

import com.example.qms.model.Users;

import java.util.List;


public interface UserService {
    Users findByIdAndPassword(String userid, String password);

    Users findById(Integer id);

    Users findByUserNameAndPassword(String uname, String password);

    List<Users> allUser();

    void save(Users bduser);
}
