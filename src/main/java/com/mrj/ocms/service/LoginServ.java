package com.mrj.ocms.service;

import com.mrj.ocms.model.Login;

public interface LoginServ {
	
	public String addLogin(Login login);
	
	public String  updateLogin(Login login);
	
	public String deleteLogin(Login login);
	
	public Login doLogin(String username, String password);
	
}
