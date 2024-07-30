package com.mrj.ocms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mrj.ocms.model.User;

public interface UserRepo extends JpaRepository<User, Integer>{

}
