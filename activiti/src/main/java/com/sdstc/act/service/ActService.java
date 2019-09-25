package com.sdstc.act.service;

import java.util.Map;

public interface ActService {
	public void test();

	public String startInstance(String depId, Map<String, Object> params);

	public String complateTask(String instanceId, String userId, Map<String, Object> params);
	
	public void testImage();
}
