package com.sdstc.jacob;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;

public class ClientTest {
	public static void main(String[] args) {
		ActiveXComponent xl = new ActiveXComponent("SAClient.SAapi.9");
		Dispatch xlo = (Dispatch) (xl.getObject());
		try {
			//Dispatch.call(xlo, "GetAllDomains");
			Dispatch.call(xlo, "Login", "http://172.16.200.13:8080/qcbin", "cheng", "qwe123-=");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// xl.invoke("Quit", new Variant[] {});
		}

	}
}
