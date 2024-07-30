package com.mrj.ocms.repository_implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mrj.ocms.model.Login;
import com.mrj.ocms.repository.LoginRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class LoginRepoImple implements LoginRepo {

	@Autowired
	EntityManager em;

	@Override
	public String save(Login login) {
		try {
			em.persist(login);
			return "Success";
		} catch (Exception e) {
			return "Failure";
		}
	}

	@Override
	public String update(Login login) {
		try {
			Login lg = em.find(Login.class, login.getLogId());
			if (lg != null) {
				em.merge(login);
				return "Success";
			} else {
				return "Failure";
			}
		} catch (Exception e) {
			return "Failure";
		}
	}

	@Override
	public String delete(Login login) {
		try {
			Login lg = em.find(Login.class, login.getLogId());
			if (lg != null) {
				em.remove(login);
				return "Success";
			} else {
				return "Failure";
			}
		} catch (Exception e) {
			return "Failure";
		}
	}

	@Override
	public Login login(String userName, String password) {
		try {
			String sql = "select lg from Login lg where userName = :userName and password = :password";
			Query query = em.createQuery(sql).setParameter("userName", userName).setParameter("password", password);
			Login login = (Login) query.getSingleResult();
			if (login != null) {
				return login;
			} else {
				return null;
			}
		} catch (Exception e) {
			return null;
		}
	}
}
