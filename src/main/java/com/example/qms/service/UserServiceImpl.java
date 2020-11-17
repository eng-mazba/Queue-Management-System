package com.example.qms.service;

import com.example.qms.model.Users;
import com.example.qms.reposetory.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public Users findByIdAndPassword(String userid, String password) {
        return usersRepository.findByIdAndPassword(userid, password);
    }

    @Override
    public Users findById(Integer id) {
        return usersRepository.findById(id).get();
    }

    @Override
    public Users findByUserNameAndPassword(String uname, String password) {
        return usersRepository.findByUserNameAndPassword(uname,password);
    }

    @Override
    public List<Users> allUser() {
        return usersRepository.findAll();
    }

    @Override
    public void save(Users bduser) {
        usersRepository.save(bduser);
    }

}
