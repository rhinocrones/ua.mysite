package ua.mysite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import ua.mysite.entity.Brand;

public interface BrandRepository extends JpaRepository<Brand, Integer>{

	Brand findByBrand(String brand);
	
	@Modifying
	@Query("DELETE FROM Brand b WHERE b.brand=:brand")
	@Transactional
	void deleteByBrand(@Param("brand") String brand);
}
