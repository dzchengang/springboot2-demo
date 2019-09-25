package com.sdstc.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShiroTest {
	private static final transient Logger log = LoggerFactory.getLogger(ShiroTest.class);
	public static void main(String[] args) {
		
		DefaultSecurityManager  defaultSecurityManager=new DefaultSecurityManager();
		defaultSecurityManager.setRealm(new MyRealm());
		
		SecurityUtils.setSecurityManager(defaultSecurityManager);
		Subject currentUser = SecurityUtils.getSubject();
		
		UsernamePasswordToken token = new UsernamePasswordToken("name", "zhang2");
		
		System.out.println(currentUser.isAuthenticated());
		
		currentUser.login(token);
                        	
		System.out.println(currentUser.isAuthenticated());
		System.out.println(currentUser.hasRole("admin"));
		
		currentUser.logout();
		
	}
}
