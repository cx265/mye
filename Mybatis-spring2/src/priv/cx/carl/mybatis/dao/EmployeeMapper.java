package priv.cx.carl.mybatis.dao;

import java.util.List;

import priv.cx.carl.mybatis.bean.Employee;

public interface EmployeeMapper {

	public Employee getEmpById(Integer id);

	public List<Employee> getEmps();

}
