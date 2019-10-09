package com.sdstc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private MobileLoginProvider  mobileLoginProvider;
	@Autowired
	private SuccessHandler successHandler;
	@Autowired
	private FailureHandler failureHandler;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		MobileLoginFilter mobileLoginFilter=new MobileLoginFilter();
		mobileLoginFilter.setAuthenticationManager(super.authenticationManager());
		mobileLoginFilter.setAuthenticationSuccessHandler(successHandler);
		mobileLoginFilter.setAuthenticationFailureHandler(failureHandler);
		
		http.authorizeRequests() //定义哪些url需要保护，哪些url不需要保护
		.antMatchers("/", "/home").permitAll()
		.antMatchers("/admin").hasRole("ADMIN")
		.antMatchers("/user").access("hasRole('ADMIN') or hasRole('USER')")
		.anyRequest().authenticated()//其他url 登录即可访问
		.and()
		.authenticationProvider(mobileLoginProvider)
		.addFilterAfter(mobileLoginFilter, UsernamePasswordAuthenticationFilter.class)
		.addFilterBefore(new ValidCodeFilter(), UsernamePasswordAuthenticationFilter.class);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(14);
	}
}
