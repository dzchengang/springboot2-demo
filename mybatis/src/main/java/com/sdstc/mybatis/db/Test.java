package com.sdstc.mybatis.db;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] b={"C","D","E"};
		List<String> orgs=Arrays.asList(b);
		
		String[] a={"A","B","D"};
		List<String> permOrgs=Arrays.asList(a);
		List<String> result= orgs.stream().filter(orgId->permOrgs.contains(orgId)).collect(Collectors.toList());
		
		System.out.println(result);
	}

}
