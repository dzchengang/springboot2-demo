package com.sdstc.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

import com.sdstc.service.impl.JWTTokenEnhancer;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {
	@Autowired
	private ClientDetailsService clientDetailsServiceJdbc;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private RedisConnectionFactory redisConnectionFactory;
	@Autowired
	private JWTTokenEnhancer jwtTokenEnhancer;
	
	/**
	 * 用来配置客户端详情服务,客户端详情信息在这里进行初始化
	 */
	@Override
	public void configure(ClientDetailsServiceConfigurer configurer) throws Exception {
		configurer.withClientDetails(clientDetailsServiceJdbc);
	}

	/**
	 * 用来配置令牌端点(TokenEndpoint)的安全约束
	 */
	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		super.configure(security);
	}

	/**
	 * 配置授权服务器的Token存储方式、Token配置、授权模式
	 */
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		/*
		 * endpoints.tokenStore(tokenStore())
		 * .accessTokenConverter(jwtAccessTokenConverter())
		 * .authenticationManager(authenticationManager);
		 */
		
		TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
	    tokenEnhancerChain.setTokenEnhancers(
	    Arrays.asList(jwtTokenEnhancer, jwtAccessTokenConverter()));
	 
	    endpoints.tokenStore(tokenStore())
	             .tokenEnhancer(tokenEnhancerChain)
	             .authenticationManager(authenticationManager);

	}

	public TokenStore tokenStore() {
		return new RedisTokenStore(redisConnectionFactory);
	}

	private JwtAccessTokenConverter jwtAccessTokenConverter() {
		JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
		converter.setSigningKey("qwe123-=");
		return converter;
	}

}
