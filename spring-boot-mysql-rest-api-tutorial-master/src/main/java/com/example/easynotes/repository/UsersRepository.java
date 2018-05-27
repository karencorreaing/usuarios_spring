/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.easynotes.repository;


import com.example.easynotes.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author macbook
 */
@Repository
public interface UsersRepository extends JpaRepository<Users, Long>{
    
}

