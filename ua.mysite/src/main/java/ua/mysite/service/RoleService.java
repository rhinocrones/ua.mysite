package ua.mysite.service;

import java.util.List;

import ua.mysite.entity.Role;

public interface RoleService {

	void save(String role);
	
	Role findByRole(String role);
	
	void deleteByRole(String role);
	
	List<Role> findAll();
}
