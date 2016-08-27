package ua.filter;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import ua.mysite.entity.Brand;
import ua.mysite.entity.Category;
import ua.mysite.entity.Product;
import ua.mysite.entity.Size;

public class ProductFilter {
	private final CriteriaBuilder cb;
	private final CriteriaQuery<Product> cq;
	private final Root<Product> root;

	public ProductFilter(EntityManager em) {
		cb = em.getCriteriaBuilder();
		cq = cb.createQuery(Product.class);
		root = cq.from(Product.class);
		cq.select(root);
	}

	public CriteriaBuilder getCb() {
		return cb;
	}

	public CriteriaQuery<Product> getCq() {
		return cq;
	}

	public Root<Product> getRoot() {
		return root;
	}

	public void filterBySize(int nextInt, EntityManager em) {
		Join<Product, Size> joinSize = root.join("size");
		Predicate predicate = cb.equal(joinSize.get("size"), nextInt);
		cq.where(predicate);
		print(em);
	}

	public void filterByBrand(String name, EntityManager em) {
		Join<Product, Brand> joinBrand = root.join("brand");
		Predicate predicate = cb.equal(joinBrand.get("brand"), name);
		cq.where(predicate);
		print(em);
	}

	public void filterByCategory(String name, EntityManager em) {
		Join<Product, Category> joinCategory = root.join("category");
		Predicate predicate = cb.equal(joinCategory.get("category"), name);
		cq.where(predicate);
		print(em);
	}
	
	public void filterByCategoryAndBrand(String nameCategory, String nameBrand, EntityManager em){
		Join<Product, Category> joinCategory = root.join("category");
		Predicate predicateCat = cb.equal(joinCategory.get("category"), nameCategory);
		Join<Product, Brand> joinBrand = root.join("brand");
		Predicate predicateBr = cb.equal(joinBrand.get("brand"), nameBrand);
		Predicate predicateaAll = cb.and(predicateCat, predicateBr);
		cq.where(predicateaAll);
		print(em);
	}
	public void filterByCategoryAndSize(String nameCategory, int size, EntityManager em){
		Join<Product, Category> joinCategory = root.join("category");
		Predicate predicateCat = cb.equal(joinCategory.get("category"), nameCategory);
		Join<Product, Size> joinSize = root.join("size");
		Predicate predicateSz = cb.equal(joinSize.get("size"), size);
		Predicate predicateaAll = cb.and(predicateCat, predicateSz);
		cq.where(predicateaAll);
		print(em);
	}
	public void filterByBrandAndSize(String nameBrand, int size, EntityManager em){
		Join<Product, Brand> joinBrand = root.join("brand");
		Predicate predicateBr = cb.equal(joinBrand.get("brand"), nameBrand);
		Join<Product, Size> joinSize = root.join("size");
		Predicate predicateSz = cb.equal(joinSize.get("size"), size);
		Predicate predicateaAll = cb.and(predicateBr, predicateSz);
		cq.where(predicateaAll);
		print(em);
	}
	public void filterByCategoryByBrandAndSize(String nameCategory, String nameBrand, int size, EntityManager em){
		Join<Product, Category> joinCategory = root.join("category");
		Predicate predicate = cb.equal(joinCategory.get("category"), nameCategory);
		Join<Product, Brand> joinBrand = root.join("brand");
		Predicate predicate2 = cb.equal(joinBrand.get("brand"), nameBrand);
		Join<Product, Size> joinSize = root.join("size");
		Predicate predicate3 = cb.equal(joinSize.get("size"), size);
		Predicate predicate4 = cb.and(predicate, predicate2, predicate3);
		cq.where(predicate4);
		print(em);
	}
	public void print(EntityManager em){
		List<Product> products = em.createQuery(cq).getResultList();
		for (Product product : products) {
			System.out.println(product.getName());
		}
	}
}
