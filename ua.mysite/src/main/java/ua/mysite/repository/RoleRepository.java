package ua.mysite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import ua.mysite.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

	Role findByRole(String role);

	@Modifying
	@Query("DELETE FROM Role r WHERE r.role=:role")
	@Transactional
	void deleteByRole(@Param("role") String role);
}
