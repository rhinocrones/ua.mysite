package ua.mysite.service;

import java.util.List;

import ua.mysite.entity.Usr;

public interface UsrService {

	void save(String username, String email, String password, String role);
	
	Usr findByUsername(String username);
	
	void deleteByUsername(String username);
	
	List<Usr> findAll();
}
