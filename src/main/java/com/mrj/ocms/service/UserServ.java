package com.mrj.ocms.service;

import java.util.List;
import com.mrj.ocms.model.User;

public interface UserServ {

	public String addUser(User us);

	public List<User> listAllUsers();

	public User getUserById(int id);

	public String updateUser(User us);

	public String deleteUser(int id);

}
