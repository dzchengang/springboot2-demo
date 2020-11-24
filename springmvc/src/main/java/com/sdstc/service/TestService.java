package com.sdstc.service;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.crypto.SmUtil;
import cn.hutool.crypto.symmetric.SM4;
import org.springframework.stereotype.Service;

import com.sdstc.controller.DataSourceContextHolder;

@Service("testService")
public class TestService {
	public String test(String code) {

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		String dbCode = DataSourceContextHolder.getDbType();
		if (!code.equals(dbCode)) {
			System.out.println("--");
		}
		return null;
	}

	public static void main(String[] args) {

		String key="chengisgentorman";

		SM4 sm4 = (SM4) SmUtil.sm4(key.getBytes());

		/*String encryptHex =sm4.encryptHex("{\n" +
				"    \"name\":\"cheng\",\n" +
				"    \"pwd\":\"qwe123-=\"\n" +
				"}");
		System.out.println(encryptHex);*/

		System.out.println(sm4.decryptStr("d6e4b18d705421589d2288c3efa0da5e883cb9436d19ff48988d7970bdbd11afd4be2f98d7383bd4c5a1be039b8844bb460ec3f81933cb73f6c8fcf5eb4c904efa33acb4c50b699fb757eeb7e095dabc7f51e3b1152d83ab6eae431127183353994cf163c5e0b7daebcde4e351ea605ad92e6686430acb96b69d88a9798880f0d210094271b09c801685ef0cf3dcbcc70e78ec5dd3e36e0c0c29b50bc0e8ffd77e548211d09a24576fb449c2a41b58d1f02ec798c7e9dee77c51f809acd97df1bb66c9f7151975ef68b92713f80b7213b08e2f9cc4f8b73961406b23873798fcb420ab5c7c9788316b0d40358d2e2254e0a75ec2f6c97de61ef2052ef381cb7c22dae0206a43395252f668c11cae5b22f21851dddf7707a5627d15360bbabe49456aac62ee33ccb53ab5577bbba579fa657e8babbfeea416129843a1c7cc946b9286f41706564aab4cf99260d27dd73cfa33acb4c50b699fb757eeb7e095dabc7e3c3e77eb006ed7b9afc29d040b4e68cd1d30dafb9f3b680640d4d08b2b5d3612db22b370b5c0df82e6bc4159e0c3de2ec006a8da478d2efa16c1a524efbecbf02ec798c7e9dee77c51f809acd97df1bb66c9f7151975ef68b92713f80b7213b08e2f9cc4f8b73961406b23873798fcb420ab5c7c9788316b0d40358d2e2254c634b6897d1dc8c1900bfaa25ecea287", CharsetUtil.CHARSET_UTF_8));
	}
}
