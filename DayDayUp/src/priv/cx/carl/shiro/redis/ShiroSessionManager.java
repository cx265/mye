package priv.cx.carl.shiro.redis;

import java.io.Serializable;

import javax.servlet.ServletRequest;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.SessionKey;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.web.session.mgt.WebSessionKey;

/**
 * @author 作者:chenxuan E-mail:chenx265@163.com
 * @version 创建时间：2017年12月5日 下午1:26:31
 */
public class ShiroSessionManager extends DefaultWebSessionManager {

	/**
	 * 获取session 优化单次请求需要多次访问redis的问题
	 * 
	 * @param sessionKey
	 * @return
	 * @throws UnknownSessionException
	 */
	@Override
	protected Session retrieveSession(SessionKey sessionKey) throws UnknownSessionException {
		Serializable sessionId = getSessionId(sessionKey);
		ServletRequest request = null;
		if (sessionKey instanceof WebSessionKey) {
			request = ((WebSessionKey) sessionKey).getServletRequest();
		}

		if (request != null && null != sessionId) {
			Object sessionObj = request.getAttribute(sessionId.toString());
			if (sessionObj != null) {
				return (Session) sessionObj;
			}
		}

		Session session = super.retrieveSession(sessionKey);
		if (request != null && null != sessionId) {
			request.setAttribute(sessionId.toString(), session);
		}
		return session;
	}

}
