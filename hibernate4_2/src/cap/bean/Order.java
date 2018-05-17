package cap.bean;

import java.util.HashSet;
import java.util.Set;

public class Order {

	private Integer id;
	private String date;
	private Set<Product> products = new HashSet<Product>();

	public Order() {
	}

	public Order(String date) {
		this.date = date;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	
}
