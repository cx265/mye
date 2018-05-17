package priv.cx.carl.ssm.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import priv.cx.carl.ssm.dao.UserDao;
import priv.cx.carl.ssm.pojo.User;

/**
 * @author 作者:chenxuan E-mail:chenx265@163.com
 * @version 创建时间：2017年9月1日 上午9:48:28
 */
@RunWith(SpringJUnit4ClassRunner.class) //使用spring的测试框架
@ContextConfiguration(locations = {"classpath*:applicationContext-*.xml"}) //加载spring配置文件
public class TestSSM {

	@Autowired
	private UserDao userDao;
	
	@Test
	public void testLogin() {
		User user = new User("tom", "1234");
		boolean ret = userDao.login(user);
		String username = user.getUsername();
		System.out.println(ret);
		System.out.println(username);
	}
}
