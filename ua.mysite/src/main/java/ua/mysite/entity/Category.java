package ua.mysite.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {
 
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
 
    private String category;
 
    @OneToMany(mappedBy="category")
    private List<Product> products;
 
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
  
    public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public List<Product> getProducts() {
        return products;
    }
 
    public void setProducts(List<Product> products) {
        this.products = products;
    }
 
}
