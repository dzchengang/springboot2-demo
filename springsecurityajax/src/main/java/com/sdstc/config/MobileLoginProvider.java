package com.sdstc.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.sdstc.service.UserService;

@Component
public class MobileLoginProvider implements AuthenticationProvider {
	protected static final Logger logger = LoggerFactory.getLogger(MobileLoginProvider.class);
	@Autowired
	private UserService userService;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		MobileLoginToken token = (MobileLoginToken) authentication;
		//UserDetails user = userService.getUserDetailByPhone((String) token.getPrincipal());
		UserDetails user = userService.getUserDetailByPhone("admin");
		if (user == null) {
			throw new InternalAuthenticationServiceException("无法获取用户信息");
		}
		UsernamePasswordAuthenticationToken result = new UsernamePasswordAuthenticationToken(user, user.getPassword(), user.getAuthorities());
		result.setDetails(token.getDetails());
		return result;

	}

	/**
	 * 判断是否mobilelogintoken
	 */
	@Override
	public boolean supports(Class<?> authentication) {
		return MobileLoginToken.class.isAssignableFrom(authentication);
	}

}
