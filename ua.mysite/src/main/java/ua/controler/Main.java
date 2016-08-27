package ua.controler;

import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ua.mysite.entity.Brand;
import ua.mysite.entity.Category;
import ua.mysite.entity.Product;
import ua.mysite.entity.Role;
import ua.mysite.entity.UserOrder;
import ua.mysite.entity.Usr;
import ua.mysite.service.BrandService;
import ua.mysite.service.CategoryService;
import ua.mysite.service.ProductService;
import ua.mysite.service.RoleService;
import ua.mysite.service.SizeService;
import ua.mysite.service.UserOrderService;
import ua.mysite.service.UsrService;

public class Main {
	static final ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
			"/META-INF/applicationContext.xml");

	static final BrandService BRAND_SERVICE = context
			.getBean(BrandService.class);

	static final CategoryService CATEGORY_SERVICE = context
			.getBean(CategoryService.class);

	static final SizeService SIZE_SERVICE = context.getBean(SizeService.class);

	static final ProductService PRODUCT_SERVICE = context
			.getBean(ProductService.class);

	static final RoleService ROLE_SERVICE = context.getBean(RoleService.class);

	static final UsrService USR_SERVICE = context.getBean(UsrService.class);

	static final UserOrderService USER_ORDER_SERVICE = context
			.getBean(UserOrderService.class);

	public static void main(String[] args) {
		List<Brand> brands = BRAND_SERVICE.findAll();
		for (Brand brand : brands) {
			System.out.println(brand.getBrand());
		}
		List<Category> categories = CATEGORY_SERVICE.findAll();
		for (Category category : categories) {
			System.out.println(category.getCategory());
		}

		List<Product> products = PRODUCT_SERVICE.findAll();
		for (Product product : products) {
			System.out.println(product.getName());
		}
		List<Role> roles = ROLE_SERVICE.findAll();
		for (Role role : roles) {
			System.out.println(role.getRole());
		}
		List<Usr> usrs = USR_SERVICE.findAll();
		for (Usr usr : usrs) {
			System.out.println(usr.getUsername());
		}
		List<UserOrder> userOrders = USER_ORDER_SERVICE.findAll();
		for (UserOrder userOrder : userOrders) {
			System.out.println(userOrder.getProduct());
		}
		context.close();
	}

}
