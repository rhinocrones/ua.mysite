package ua.mysite.service;

import java.util.List;

import ua.mysite.entity.Brand;

public interface BrandService {

	void save(String brand);
	
	Brand findByBrand(String brand);
	
	void deleteByBrand(String brand);
	
	List<Brand> findAll();
	
}
