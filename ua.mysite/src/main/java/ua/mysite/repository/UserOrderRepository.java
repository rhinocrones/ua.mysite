package ua.mysite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import ua.mysite.entity.UserOrder;

public interface UserOrderRepository extends JpaRepository<UserOrder, Integer> {

	UserOrder findById(int id);

	@Modifying
	@Query("DELETE FROM UserOrder uo WHERE uo.id=:id")
	@Transactional
	void deleteById(@Param("id") int id);
}
