package cx.carl.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import cx.carl.city.Department;
import cx.carl.city.Employee;
import cx.carl.city.Location;
import cx.carl.dao.BaseDao;

public class EmployeeServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String methodName = request.getParameter("method");
		try {
			Method method = getClass().getDeclaredMethod(methodName,
					HttpServletRequest.class, HttpServletResponse.class);
			method.invoke(this, request,response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private BaseDao baseDao = new BaseDao();

	public void listLocations(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String sql = "SELECT location_id locationId ,city FROM locations";
		List<Location> locations = baseDao.getForList(sql, Location.class);
		request.setAttribute("locations", locations);
		request.getRequestDispatcher("/WEB-INF/page/employee.jsp").forward(
				request, response);
	}
	
	public void listDepartments(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String locationId = request.getParameter("locationId");
		String sql = "SELECT department_id departmentId ,department_name departmentName FROM departments d WHERE d.location_id=?";
		List<Department> departments = baseDao.getForList(sql, Department.class, Integer.parseInt(locationId));
		ObjectMapper mapper = new ObjectMapper();
		String result = mapper.writeValueAsString(departments);
		response.setContentType("text/javascript");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		response.getWriter().print(result);
	}
	
	public void listEmployees(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String departmentId = request.getParameter("departmentId");
		String sql = "SELECT employee_id employeeId ,employee_name employeeName FROM employees e WHERE e.department_id=?";
		List<Employee> employees = baseDao.getForList(sql, Employee.class, Integer.parseInt(departmentId));
		ObjectMapper mapper = new ObjectMapper();
		String result = mapper.writeValueAsString(employees);
		response.setContentType("text/javascript");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		response.getWriter().print(result);
	}

}
