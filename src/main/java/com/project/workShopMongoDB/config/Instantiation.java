package com.project.workShopMongoDB.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.project.workShopMongoDB.domain.Post;
import com.project.workShopMongoDB.domain.User;
import com.project.workShopMongoDB.repository.PostRepository;
import com.project.workShopMongoDB.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        repository.deleteAll();
        User maria = new User(null, "Maria Brown", "maria@gmail.com"); 
        User alex = new User(null, "Alex Green", "alex@gmail.com"); 
        User bob = new User(null, "Bob Grey", "bob@gmail.com"); 
        repository.saveAll(Arrays.asList(maria, alex, bob));

        postRepository.deleteAll();
        Post post1 = new Post(null, sdf.parse("21/03/2018"), "partiu viagem", "vou viajar para sp, abraços", maria);
        Post post2 = new Post(null, sdf.parse("22/03/2018"), "bom dia", "acordei feliz hoje!", maria);
        postRepository.saveAll(Arrays.asList(post1, post2));
    }
}
