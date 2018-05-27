/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.easynotes.controller;

import com.example.easynotes.exception.ResourceNotFoundException;
import com.example.easynotes.model.Users;
import com.example.easynotes.repository.UsersRepository;
import java.io.File;
import java.util.List;
import javax.validation.Valid;
import org.apache.commons.codec.digest.DigestUtils;
import static org.apache.commons.codec.digest.MessageDigestAlgorithms.SHA_224;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author macbook
 */
@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    UsersRepository usersRepository;

    @GetMapping("/users")
    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    @PostMapping("/user")
    public Users createUser(@Valid @RequestBody Users user) {
        String hdigest = new DigestUtils(SHA_224).digestAsHex(user.getUserPass());
        user.setUserPass(hdigest);
        return usersRepository.save(user);
    }

    @GetMapping("/users/{id}")
    public Users getUserById(@PathVariable(value = "id") Long noteId) {
        return usersRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));
    }

 
}
