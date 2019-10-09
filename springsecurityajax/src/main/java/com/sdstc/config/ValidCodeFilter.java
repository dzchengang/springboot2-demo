package com.sdstc.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.OncePerRequestFilter;

public class ValidCodeFilter extends OncePerRequestFilter {
	protected static final Logger logger = LoggerFactory.getLogger(ValidCodeFilter.class);

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		if(request.getRequestURI().equals("/login/mobile") && request.getMethod().equals("GET")){
			logger.info("---validcode--");
		}
		
		filterChain.doFilter(request, response);
	}

}
