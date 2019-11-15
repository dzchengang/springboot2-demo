package com.sdstc.config;

import java.io.Serializable;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.web.util.WebUtils;

public class TokenSessionManager extends DefaultWebSessionManager{
	private static final String AUTHORIZATION = "Authorization";
	private static final String REFERENCED_SESSION_ID_SOURCE = "Stateless request";

	
	@Override
	protected Serializable getSessionId(ServletRequest request, ServletResponse response) {
		String id = WebUtils.toHttp(request).getHeader(AUTHORIZATION);
		// 如果请求头中有 Authorization 则其值为sessionId
		if (!StringUtils.isEmpty(id)) {
			request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_SOURCE, REFERENCED_SESSION_ID_SOURCE);
			request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID, id);
			request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_IS_VALID, Boolean.TRUE);
			
			HttpServletResponse response2=(HttpServletResponse) response;
			Cookie cookie=new Cookie("JSESSIONID", id);
			response2.addCookie(cookie);
			return id;
		}else if(request.getParameter("token")!=null){
			return String.valueOf(request.getParameter("token"));
		}else{
			return null;
		}
	}
}
