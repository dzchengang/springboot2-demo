package com.sdstc.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

/**
 * 客户端详情
 * @author cheng
 *
 */
@Service("clientDetailsServiceJdbc")
@Slf4j
public class ClientDetailsServiceImpl implements ClientDetailsService{
	
	@Override
	public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
		log.info("--loadClientByClientId--"+clientId);
		BaseClientDetails  baseClientDetails=new BaseClientDetails();
		//用来标识客户的Id
		baseClientDetails.setClientId(clientId);
		//用来标识客户端的安全码
		baseClientDetails.setClientSecret(passwordEncoder().encode("111111"));
		
		//用来限制客户端的访问范围
		List<String> scopes=new ArrayList<String>();
		scopes.add("write");
		scopes.add("read");
		baseClientDetails.setScope(scopes);
		
		//用来标识客户端使用的授权类型
		List<String> authorizedGrantTypes=new ArrayList<String>();
		authorizedGrantTypes.add("authorization_code");
		baseClientDetails.setAuthorizedGrantTypes(authorizedGrantTypes);
		
		//此客户端可以使用的权限
		List<GrantedAuthority> authorities=new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ADMIN"));
		authorities.add(new SimpleGrantedAuthority("USER"));
		baseClientDetails.setAuthorities(authorities);
		
		//设置返回地址
		Set<String> redirectUris=new HashSet<String>();
		redirectUris.add("http://www.baidu.com");
		baseClientDetails.setRegisteredRedirectUri(redirectUris);
		return baseClientDetails;
	}
	
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(14);
	}

	
}
