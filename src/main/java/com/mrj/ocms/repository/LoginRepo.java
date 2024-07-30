package com.mrj.ocms.repository;

import com.mrj.ocms.model.Login;

public interface LoginRepo {
	
	String save(Login login);
	
	String update(Login login);
	
	String delete(Login login);
	
	Login login(String username, String password);

}
