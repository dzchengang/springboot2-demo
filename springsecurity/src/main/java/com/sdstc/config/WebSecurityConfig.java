package com.sdstc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests() //定义哪些url需要保护，哪些url不需要保护
		.antMatchers("/", "/home").permitAll()
		.antMatchers("/admin").hasRole("ADMIN")
		.antMatchers("/user").access("hasRole('ADMIN') or hasRole('USER')")
		.anyRequest().authenticated()//其他url 登录即可访问
		.and()
		.formLogin()
		.loginPage("/login").permitAll()//定义当需要用户登录时候，转到的登录页面
		.and()
		.logout().permitAll();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// 设置userservice 设置 password
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(14);
	}
}
