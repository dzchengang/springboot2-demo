package com.sdstc.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

public class MobileLoginFilter extends AbstractAuthenticationProcessingFilter {
	protected static final Logger logger = LoggerFactory.getLogger(MobileLoginFilter.class);

	/**
	 * URL匹配
	 */
	public MobileLoginFilter() {
		super(new AntPathRequestMatcher("/login/mobile", "GET"));
	}

	/**
	 * 封装空session
	 */
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
		String phone = request.getParameter("phone");
		MobileLoginToken token = new MobileLoginToken(phone);
		return this.getAuthenticationManager().authenticate(token);
	}
}
