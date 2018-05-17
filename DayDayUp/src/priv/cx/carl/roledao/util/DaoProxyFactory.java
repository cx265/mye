package priv.cx.carl.roledao.util;

import java.lang.annotation.AnnotationFormatError;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import priv.cx.carl.roledao.annotation.Implement;
import priv.cx.carl.roledao.annotation.Permission;
import priv.cx.carl.roledao.context.RoleContext;
import priv.cx.carl.roledao.dao.BaseDao;

/**
 * @author 作者:chenxuan E-mail:chenx265@163.com
 * @version 创建时间：2017年9月14日 下午3:22:30
 */
public abstract class DaoProxyFactory {
	
	@SuppressWarnings("unchecked")
	public static <T> T newRoleDaoProxy(Class<T> dao) {
		Implement implAnnotation = dao.getAnnotation(Implement.class);

		if (implAnnotation == null)
			throw new AnnotationFormatError("该接口未定义实现类的注解");

		BaseDao implClass = null;
		try {
			implClass = implAnnotation.value().newInstance();
		} catch (Exception e) {
			throw new RuntimeException("该接口所定义的实现类不能被实例化", e);
		}

		return (T) Proxy.newProxyInstance(DaoProxyFactory.class.getClassLoader(), new Class<?>[] { dao },
				new RoleInvocationHandler(implClass));
	}

	private static final class RoleInvocationHandler implements InvocationHandler {
		private BaseDao target;

		public RoleInvocationHandler(BaseDao target) {
			this.target = target;
		}

		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			Permission permitAnnotation = method.getAnnotation(Permission.class);

			outter: if (permitAnnotation != null) {
				Role currentRole = RoleContext.INSTANCE.getCurrentRole();
				for (Role permitRole : permitAnnotation.value()) {
					if (permitRole.equals(currentRole))
						break outter;
				}
				throw new SecurityException("当前用户不允许执行此操作");
			}

			return method.invoke(target, args);
		}
	}
	
}
