package com.mrj.ocms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mrj.ocms.model.Login;
import com.mrj.ocms.service_impl.LoginServImplementation;

@RestController
@CrossOrigin("http://localhost:3001")
@RequestMapping("/login")
public class LoginController {

	@Autowired
	LoginServImplementation service;

	@PostMapping
	public String doAddNewLogin(@RequestBody Login login) {
		String msg = "";
		try {
			msg = service.addLogin(login);
		} catch (Exception e) {
			msg = "Transaction add new user failed";
		}
		return msg;
	}

	@PutMapping
	public String doUpdateLogin(@RequestBody Login login) {
		String msg = "";
		try {
			msg = service.updateLogin(login);
		} catch (Exception e) {
			msg = "Transaction add new user failed";
		}
		return msg;

	}

	@GetMapping("{username}/{password}")
	public Login doLoginUser(@PathVariable("username") String username, @PathVariable("password") String password) {
		Login login;
		login = service.doLogin(username, password);
		if(login!=null) {
			return login;			
		} else {
			return null;
		}
	}
}
