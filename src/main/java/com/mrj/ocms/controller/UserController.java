package com.mrj.ocms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mrj.ocms.model.User;
import com.mrj.ocms.service_impl.UserServImpl;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserServImpl service;
	
	@PostMapping
	public String doAddNewUser(@RequestBody User us) {
		String msg = "";
		try {
			msg = service.addUser(us);
		} catch (Exception e) {
			msg = "Transaction insert failed";
		}
		return msg;
	}
	
	@PutMapping
	public String doUpdateUser(@RequestBody User us) {
		String msg = "";
		try {
			msg = service.updateUser(us);
		} catch (Exception e) {
			msg = "Transaction update failed";
		}
		return msg;
	}
	
	@GetMapping("{uid}")
	public User doFindUserById(@PathVariable("uid") int id) {
		User us = service.getUserById(id);
		if(us != null) {
			return us;			
		} else {
			return null;
		}
	}

	@DeleteMapping("{uid}")
	public String doDeleteUserById(@PathVariable("uid") int id) {
		String msg = "";
		try {
			msg = service.deleteUser(id);
		} catch (Exception e) {
			msg = "Transaction Delete Failed";
		}
		return msg;
	}
	
	@GetMapping("/allUsers")
	public List<User> doFindAllUsers(){
		return service.listAllUsers();
	}

}
