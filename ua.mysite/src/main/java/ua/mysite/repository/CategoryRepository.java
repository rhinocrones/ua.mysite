package ua.mysite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import ua.mysite.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{

	Category findByCategory(String category);
	
	@Modifying
	@Query("DELETE FROM Category c WHERE c.category=:category")
	@Transactional
	void deleteByCategory(@Param("category") String category);
}
