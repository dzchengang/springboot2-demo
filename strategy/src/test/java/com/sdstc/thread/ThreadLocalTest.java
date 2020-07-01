package com.sdstc.thread;

public class ThreadLocalTest {
	static Integer a = 1;
	
	public static void main(String[] args) {
		ThreadLocal<Integer> tl=new ThreadLocal<>();
		tl.set(a);
		
		for (int i = 0; i < 100; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					a=a+2;
					System.out.println(a);
				}
			}).start();
		}
	}
}
