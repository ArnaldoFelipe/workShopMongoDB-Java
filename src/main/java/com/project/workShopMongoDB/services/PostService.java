package com.project.workShopMongoDB.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.project.workShopMongoDB.domain.Post;
import com.project.workShopMongoDB.exception.ObjectNotFoundException;
import com.project.workShopMongoDB.repository.PostRepository;

public class PostService {
    
    @Autowired
    PostRepository postRepository;

    public Post findById(String id){
        
        Optional<Post> post = postRepository.findById(id);
        return post.orElseThrow(() -> new ObjectNotFoundException("Objeto nao encontrado, id nao existe"));
    }
}
