package priv.cx.carl.bean;

import javax.xml.bind.annotation.XmlElement;

/**
 * @author 作者:chenxuan E-mail:chenx265@163.com
 * @version 创建时间：2017年10月24日 下午9:13:50
 */
public class Order {

	private int id;
	private String name;
	private double price;

	public Order(int id, String name, double price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public Order() {
		super();
	}

	@XmlElement(name="id",type=Integer.class, nillable=false, required=true)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", name=" + name + ", price=" + price + "]";
	}
}
