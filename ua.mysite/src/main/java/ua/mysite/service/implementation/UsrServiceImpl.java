package ua.mysite.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.mysite.entity.Role;
import ua.mysite.entity.Usr;
import ua.mysite.repository.RoleRepository;
import ua.mysite.repository.UsrRepository;
import ua.mysite.service.UsrService;

@Service
public class UsrServiceImpl implements UsrService {

	@Autowired
	private UsrRepository usrRepository;

	@Autowired
	private RoleRepository roleRepository;

	public void save(String username, String email, String password, String role) {
		if (usrRepository.findByUsername(username) == null) {
			Usr usr = new Usr();
			usr.setUsername(username);
			usr.setEmail(email);
			usr.setPassword(password);

			Role role2 = roleRepository.findByRole(role);
			if (role2 != null) {
				usr.setRole(role2);
			} else {
				role2 = new Role();
				role2.setRole(role);
				roleRepository.save(role2);
				usr.setRole(role2);
			}
		} else System.out.println("User exist");
	}

	public Usr findByUsername(String username) {
		return usrRepository.findByUsername(username);
	}

	public void deleteByUsername(String username) {
		usrRepository.deleteByUsername(username);
	}

	public List<Usr> findAll() {
		return usrRepository.findAll();
	}

}
