package com.sdstc.com4j.test;

import com.sdstc.com4j.lib.ClassFactory;
import com.sdstc.com4j.lib.ISAapi7;

public class SapiTest {
	public static void main(String[] args) {
		ISAapi7 isAapi7 = ClassFactory.createSAapi();
		//isAapi7.logout();
		isAapi7.login("http://172.16.200.13:8080/qcbin", "cheng", "qwe123-=");
		
		String users=isAapi7.getAllUsers();
		
		isAapi7.logout();
	}
}
