package ua.mysite.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.mysite.entity.Brand;
import ua.mysite.repository.BrandRepository;
import ua.mysite.service.BrandService;

@Service
public class BrandServiceImpl implements BrandService {

	@Autowired
	private BrandRepository brandRepository;

	public void save(String brand) {
		if (brandRepository.findByBrand(brand) == null) {
			Brand brand2 = new Brand();
			brand2.setBrand(brand);
			brandRepository.save(brand2);
		} else
			System.out.println("Exist");
	}

	public Brand findByBrand(String brand) {
		return brandRepository.findByBrand(brand);
	}

	public void deleteByBrand(String brand) {
		brandRepository.deleteByBrand(brand);
	}

	public List<Brand> findAll() {
		return brandRepository.findAll();
	}

}
