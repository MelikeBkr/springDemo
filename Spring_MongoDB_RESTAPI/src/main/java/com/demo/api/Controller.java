package com.demo.api;

import com.demo.entity.User;
import com.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping("/user")
public class Controller
{
    @Autowired
    private UserRepository userRepository;
    @PostConstruct
    public void init()
    {
        User user = new User();
        user.setName("Melike");
        user.setSurname("Bakır");
        userRepository.save(user);
    }
    //REST POST Method
    @PostMapping
    //user info comes either in request header
    //or in request body. RequestBody is selected.
    public ResponseEntity add(@RequestBody User user)
    {
        return ResponseEntity.ok(userRepository.save(user));
    }
    //REST GET Method
    @GetMapping
    public ResponseEntity<List<User>> listAllUsers()
    {
        return ResponseEntity.ok(userRepository.findAll());
    }
}
