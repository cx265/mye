package cx.carl.bean;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ShoppingCart {
	private Map<String, ShoppingItem> items = new HashMap<String, ShoppingItem>();
	private String bookName;
	
	public void addToCart(String bookName,int price){
		this.setBookName(bookName);
		if (items.containsKey(bookName)) {
			ShoppingItem item = items.get(bookName);
			item.setNumber(item.getNumber()+1);
		}else {
			ShoppingItem item = new ShoppingItem();
			item.setBookName(bookName);
			item.setPrice(price);
			item.setNumber(1);
			items.put(bookName, item);
		}
	}
	
	public int getTotalBookNumber() {
		int totalBookNumber = 0;
		for (ShoppingItem item:items.values()) {
			totalBookNumber += item.getNumber();
		}
		return totalBookNumber;
	}
	
	public int getTotalMoney(){
		int totalMoney = 0;
		for (ShoppingItem item:items.values()) {
			totalMoney += item.getNumber() * item.getPrice();
		}
		return totalMoney;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
}
