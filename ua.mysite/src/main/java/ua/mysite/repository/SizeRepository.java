package ua.mysite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import ua.mysite.entity.Size;

public interface SizeRepository extends JpaRepository<Size, Integer> {

	Size findBySize(int size);

	@Modifying
	@Transactional
	@Query("DELETE FROM Size s WHERE s.size=:size")
	void deleteBySize(@Param("size") int size);
}
