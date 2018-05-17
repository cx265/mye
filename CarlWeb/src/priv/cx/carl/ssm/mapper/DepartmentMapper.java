package priv.cx.carl.ssm.mapper;

import priv.cx.carl.ssm.bean.Department;

public interface DepartmentMapper {

	public Department getDeptById(Integer id);

	public Department getDeptByIdPlus(Integer id);

	public Department getDeptByIdStep(Integer id);
}
