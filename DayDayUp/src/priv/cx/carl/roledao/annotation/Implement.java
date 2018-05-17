package priv.cx.carl.roledao.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import priv.cx.carl.roledao.dao.BaseDao;

/**
 * @author 作者:chenxuan E-mail:chenx265@163.com
 * @version 创建时间：2017年9月14日 下午3:13:04
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Implement {

	Class<? extends BaseDao> value();
}
