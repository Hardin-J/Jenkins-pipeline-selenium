package com.mrj.ocms.service_impl;

import org.springframework.stereotype.Service;

import com.mrj.ocms.model.Login;
import com.mrj.ocms.repository.LoginRepo;
import com.mrj.ocms.service.LoginServ;

@Service
public class LoginServImplementation implements LoginServ{

	LoginRepo repo;
	
	public LoginServImplementation(LoginRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public String addLogin(Login login) {
		return repo.save(login);
	}

	@Override
	public String updateLogin(Login login) {
		return repo.update(login);
	}

	@Override
	public String deleteLogin(Login login) {
		return repo.delete(login);
	}

	@Override
	public Login doLogin(String username, String password) {
		return repo.login(username, password);
	}

}
