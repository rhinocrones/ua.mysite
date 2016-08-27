package ua.mysite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import ua.mysite.entity.Usr;

public interface UsrRepository extends JpaRepository<Usr, Integer>{

	Usr findByUsername(String username);
	
	@Modifying
	@Query("DELETE FROM Usr u WHERE u.username=:username")
	@Transactional
	void deleteByUsername(@Param("username") String username);
}
