package com.sdstc.act.service.impl;

import com.sdstc.act.service.ActService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.image.impl.DefaultProcessDiagramGenerator;
import org.activiti.spring.ProcessEngineFactoryBean;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

@Service("actService")
public class ActServiceImpl implements ActService {

	@Autowired
	private RuntimeService runtimeService;
	@Autowired
	private TaskService taskService;
	@Autowired
	private RepositoryService repositoryService;
	@Autowired
	private ProcessEngineFactoryBean processEngine;

	@Override
	public void test() {
		System.out.println("xx");
	}

	@Override
	public String startInstance(String depId, Map<String, Object> params) {
		ProcessInstance pi = runtimeService.startProcessInstanceById(depId, params);
		return pi.getId();
	}

	@Override
	public String complateTask(String instanceId, String userId, Map<String, Object> params) {
		Task myTask=taskService.createTaskQuery().processInstanceId(instanceId).taskAssignee(userId).singleResult();
		
		Map<String,Object> variables=taskService.getVariables(myTask.getId());
		
		if(myTask!=null) {
			taskService.complete(myTask.getId(),params);
		}

		return "";
	}

	@Override
	public void testImage(){
		InputStream ins=repositoryService.getResourceAsStream("1525", "测试.test11.png");
		try {
			FileUtils.copyInputStreamToFile(ins, new File("D:\\image.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
