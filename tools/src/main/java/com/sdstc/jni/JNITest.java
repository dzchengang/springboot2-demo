package com.sdstc.jni;

public class JNITest {
	public static native void Logout();
	
	public static void main(String[] args) {
		System.load("D:\\SAClient.dll");
		Logout();
	}
}
