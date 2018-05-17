package priv.cx.carl.mybatis.dao;

import org.apache.ibatis.annotations.Select;

import priv.cx.carl.mybatis.bean.Employee;

/**
 * @author 作者:chenxuan E-mail:chenx265@163.com
 * @version 创建时间：2017年7月2日 上午11:17:38
 */
public interface EmployeeMapperAnnotation {

	@Select("select id,last_name lastName,email,gender from tbl_employee where id = #{id}")
	public Employee getEmpById(Integer id);
}
