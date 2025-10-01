package com.project.workShopMongoDB.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.workShopMongoDB.domain.User;
import com.project.workShopMongoDB.exception.ObjectNotFoundException;
import com.project.workShopMongoDB.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;
    
    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(String id){
        Optional<User> user = repository.findById(id);
        
        return user.orElseThrow(() -> new ObjectNotFoundException("Objeto nao encontrado, id nao existe"));
    }
}
