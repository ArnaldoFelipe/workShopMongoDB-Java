package com.project.workShopMongoDB.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.workShopMongoDB.domain.User;
import com.project.workShopMongoDB.dto.UserDto;
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

    public User insert(User user){
        return repository.insert(user);
    }

    public void delete(String id){
        findById(id);
        repository.deleteById(id);
    }

    public User update(User user){
        Optional<User> newUser = repository.findById(user.getId());
        if(newUser.isEmpty()){
            throw new ObjectNotFoundException("Usuario nao existe");
        }
        User userNew = newUser.get();
        updateData(userNew, user);
        return repository.save(userNew);
    }

    public void updateData(User newUser, User user){
        newUser.setName(user.getName());
        newUser.setEmail(user.getEmail());
    }

    public User fromDto(UserDto userDto){
        return new User(userDto.getId(),userDto.getName(), userDto.getEmail());
        
    }
}
