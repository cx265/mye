package cx.carl.jackson;

import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Customer {
	
	private String id;
	private String name;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCity(){
		return "jiaxin";
	}
	//通过添加注解org.codehaus.jackson.annotate.JsonIgnore 忽略某个getter方法
	@JsonIgnore
	public String getBirth(){
		return "1994-04-21";
	}
	
	public Customer(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public static void main(String[] args) throws JsonProcessingException {
		//会自动加载getter的方法
		ObjectMapper objectMapper = new ObjectMapper();
		Customer customer = new Customer("carl","12");
		String jsonStr = objectMapper.writeValueAsString(customer);
		System.out.println(jsonStr);
		List<Customer> customers = Arrays.asList(customer,new Customer("1", "cx"));
		jsonStr = objectMapper.writeValueAsString(customers);
		System.out.println(jsonStr);
	}
}
