package com.project.workShopMongoDB.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.workShopMongoDB.domain.User;
import com.project.workShopMongoDB.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;
    
    public List<User> findAll(){
        return repository.findAll();
    }
}
