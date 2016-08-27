package ua.mysite.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.mysite.entity.Role;
import ua.mysite.repository.RoleRepository;
import ua.mysite.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;

	public void save(String role) {
		if (roleRepository.findByRole(role) == null) {
			Role role2 = new Role();
			role2.setRole(role);
			roleRepository.save(role2);
		} else
			System.out.println("Exist");
	}

	public Role findByRole(String role) {
		return roleRepository.findByRole(role);
	}

	public void deleteByRole(String role) {
		roleRepository.deleteByRole(role);

	}

	public List<Role> findAll() {
		return roleRepository.findAll();
	}

}
