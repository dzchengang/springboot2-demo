package com.sdstc.config;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

public class MyExceptionHandler implements HandlerExceptionResolver {

	public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,Object o, Exception ex) {
		ModelAndView mv = new ModelAndView();
		MappingJackson2JsonView view=new MappingJackson2JsonView();
		Map<String, Object> attributes = new HashMap<String, Object>();
		if (ex instanceof UnauthenticatedException) {
			attributes.put("code", "1000001");
			attributes.put("msg", "token错误");
		} else if (ex instanceof UnauthorizedException) {
			attributes.put("code", "1000002");
			attributes.put("msg", "用户无权限");
			attributes.put("info",ex.getMessage());
		}
		view.setAttributesMap(attributes);
		mv.setView(view);
		return mv;
	}
}
