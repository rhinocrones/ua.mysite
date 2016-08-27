package ua.mysite.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.mysite.entity.Brand;
import ua.mysite.entity.Category;
import ua.mysite.entity.Product;
import ua.mysite.entity.Size;
import ua.mysite.repository.BrandRepository;
import ua.mysite.repository.CategoryRepository;
import ua.mysite.repository.ProductRepository;
import ua.mysite.repository.SizeRepository;
import ua.mysite.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private BrandRepository brandRepository;
	@Autowired
	private SizeRepository sizeRepository;
	@Autowired
	private CategoryRepository categoryRepository;

	public void save(String name, double price, String category, String brand,
			int size) {
		Product product = new Product();

		product.setName(name);

		product.setPrice(price);

		Category category2 = categoryRepository.findByCategory(category);
		if (category2 != null) {
			product.setCategory(category2);
		} else {
			category2 = new Category();
			category2.setCategory(category);
			categoryRepository.save(category2);
			product.setCategory(category2);
		}

		Brand brand2 = brandRepository.findByBrand(brand);
		if (brand2 != null) {
			product.setBrand(brand2);
		} else {
			brand2 = new Brand();
			brand2.setBrand(brand);
			brandRepository.save(brand2);
			product.setBrand(brand2);
		}

		Size size2 = sizeRepository.findBySize(size);
		if (size2 != null) {
			product.setSize(size2);
		} else {
			size2 = new Size();
			size2.setSize(size);
			sizeRepository.save(size2);
			product.setSize(size2);
		}
		productRepository.save(product);
	}

	public Product findByName(String name) {
		return productRepository.findByName(name);
	}

	public void deleteByName(String name) {
		productRepository.deleteByName(name);

	}

	public List<Product> findAll() {
		return productRepository.findAll();
	}

}
