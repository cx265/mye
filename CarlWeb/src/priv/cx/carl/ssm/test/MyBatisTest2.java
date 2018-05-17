package priv.cx.carl.ssm.test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import priv.cx.carl.ssm.bean.EmpStatus;
import priv.cx.carl.ssm.bean.Employee;
import priv.cx.carl.ssm.bean.EmployeeExample;
import priv.cx.carl.ssm.bean.EmployeeExample.Criteria;
import priv.cx.carl.ssm.bean.OraclePage;
import priv.cx.carl.ssm.mapper.EmployeeMapper;

/*import com.atguigu.mybatis.bean.Employee;
import com.atguigu.mybatis.dao.EmployeeMapper;*/

public class MyBatisTest2 {

	public SqlSessionFactory getSqlSessionFactory() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		return new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void testMbg() throws Exception {
		List<String> warnings = new ArrayList<String>();
		boolean overwrite = true;
		File configFile = new File("conf/mbg.xml");
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = cp.parseConfiguration(configFile);
		DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config,
				callback, warnings);
		myBatisGenerator.generate(null);
	}
	
	@Test
	public void testMyBatis3Simple() throws IOException{
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession openSession = sqlSessionFactory.openSession();
		try{
			EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
			//可以从page中获取分页信息
			Page<Object> page = PageHelper.startPage(1, 3);
			List<Employee> list = mapper.selectByExample(null);
			//也可以从pageInfo中获取分页信息
			PageInfo<Employee> pageInfo = new PageInfo<Employee>(list);
			for (Employee employee : list) {
				System.out.println(employee.getId());
			}
			
			System.out.println("当前页码："+page.getPageNum());
			System.out.println("总页码："+page.getPages());
			System.out.println("总记录数："+page.getTotal());
			System.out.println("每页记录数："+page.getPageSize());
			System.out.println("当前页码："+pageInfo.getPageNum());
			System.out.println("总页码："+pageInfo.getPages());
			System.out.println("总记录数："+pageInfo.getTotal());
			System.out.println("每页记录数："+pageInfo.getPageSize());
		}finally{
			openSession.close();
		}
	}
	
	@Test
	public void testMyBatis3() throws IOException{
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession openSession = sqlSessionFactory.openSession();
		try{
			EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
			//xxxExample就是封装查询条件的
			//1、查询所有
			//List<Employee> emps = mapper.selectByExample(null);
			//2、查询员工名字中有e字母的，和员工性别是1的
			//封装员工查询条件的example
			EmployeeExample example = new EmployeeExample();
			//创建一个Criteria，这个Criteria就是拼装查询条件
			//select id, last_name, email, gender, d_id from tbl_employee 
			//WHERE ( last_name like ? and gender = ? ) or email like "%e%"
			Criteria criteria = example.createCriteria();
			criteria.andLastNameLike("%e%");
			criteria.andGenderEqualTo("1");
			Criteria criteria2 = example.createCriteria();
			criteria2.andEmailLike("%e%");
			example.or(criteria2);
			
			List<Employee> list = mapper.selectByExample(example);
			for (Employee employee : list) {
				System.out.println(employee.getId());
			}
			
		}finally{
			openSession.close();
		}
	}
	
	@Test
	public void testBatch() throws IOException{
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		//可以执行批量操作的sqlSession,传参ExecutorType.BATCH
		SqlSession openSession = sqlSessionFactory.openSession(ExecutorType.BATCH);
		long start = System.currentTimeMillis();
		try{
			EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
			for (int i = 0; i < 20; i++) {
				mapper.addEmp(new Employee((int) (Math.random()*10000+100000), "b", "1","1"));
			}
			openSession.commit();
			
			long end = System.currentTimeMillis();
			//批量：（预编译sql一次==>设置参数===>10000次===>执行（1次））
			//Parameters: 616c1(String), b(String), 1(String)==>4598
			//非批量：（预编译sql=设置参数=执行）==》10000    10200
			System.out.println("执行时长："+(end-start));
		}finally{
			openSession.close();
		}
	}
	
	/**
	 * oracle分页：
	 * 		借助rownum：行号；子查询；
	 * 存储过程包装分页逻辑
	 * @throws IOException 
	 */
	@Test
	public void testProcedure() throws IOException{
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession openSession = sqlSessionFactory.openSession();
		try{
			EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
			OraclePage page = new OraclePage();
			page.setStart(1);
			page.setEnd(5);
			mapper.getPageByProcedure(page);
			
			System.out.println("总记录数："+page.getCount());
			System.out.println("查出的数据："+page.getEmps().size());
			System.out.println("查出的数据："+page.getEmps());
		}finally{
			openSession.close();
		}
		
	}
	
	@Test
	public void testEnumUse(){
		EmpStatus login = EmpStatus.LOGIN;
		System.out.println("枚举的索引："+login.ordinal());
		System.out.println("枚举的名字："+login.name());
		
		System.out.println("枚举的状态码："+login.getCode());
		System.out.println("枚举的提示消息："+login.getMsg());
	}
	
	/**
	 * 默认mybatis在处理枚举对象的时候保存的是枚举的名字：EnumTypeHandler
	 * 改变使用：EnumOrdinalTypeHandler：
	 * @throws IOException
	 */
	@Test
	public void testEnum() throws IOException{
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession openSession = sqlSessionFactory.openSession();
		try{
			EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
			Employee employee = new Employee(1001, "enum@atguigu.com","1","1");
			//mapper.addEmp(employee);
			//System.out.println("保存成功"+employee.getId());
			//openSession.commit();
			Employee empById = mapper.getEmpById(1001);
			System.out.println(empById.getLastName());
		}finally{
			openSession.close();
		}
	}


}
