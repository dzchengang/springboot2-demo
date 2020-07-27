package com.sdstc.activiti.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.activiti.bpmn.model.BpmnModel;
import org.activiti.engine.HistoryService;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.task.Task;
import org.activiti.image.ProcessDiagramGenerator;
import org.activiti.spring.ProcessEngineFactoryBean;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sdstc.Start;
import com.sdstc.activiti.ActService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { Start.class })
public class ActServiceImplTest {
	@Autowired
	private ActService actService;
	@Autowired
	private TaskService taskService;
	@Autowired
	private RuntimeService runtimeService;
	@Autowired
	private ProcessEngineFactoryBean processEngine;
	@Autowired
	private RepositoryService repositoryService;
	@Autowired
	private HistoryService historyService;
	
	@Test
	public void testDeploment() throws FileNotFoundException, IOException {
		String content = IOUtils.toString(new FileInputStream("d://process3.bpmn"), "UTF-8");
		actService.deploment("resource3", "process3", content, "001");
	}

	@Test
	public void testStartProcess() {
		List<String> users = new ArrayList<>();
		users.add("user1");
		users.add("user2");
		users.add("user3");

		Map<String, Object> params = new HashMap<>();
		params.put("users", users);
		actService.startProcess("process3", params, "001");
	}

	@Test
	public void testComplateTaskStringMapOfStringObjectString() {
		List<Task> tasks = taskService.createTaskQuery().taskAssignee("user5").list();
		System.out.println(tasks.size());
	}

	@Test
	public void testComplateTaskStringMapOfStringObject() {
		List<String> users = new ArrayList<>();
		users.add("user4");
		users.add("user5");
		users.add("user6");
		Map<String, Object> params = new HashMap<>();
		params.put("users", users);

		taskService.complete("12523", params);
	}

	@Test
	public void suspend() {
		// 挂起
		runtimeService.suspendProcessInstanceById("12501");
		// 激活
		runtimeService.activateProcessInstanceById("12501");
	}

	@Test
	public void delete() {
		runtimeService.deleteProcessInstance("12501", "test");
	}

	@Test
	public void getProcessImage() throws IOException {
		String processDefinitionId="process3:1:4";
		
		BpmnModel bpmnModel = repositoryService.getBpmnModel(processDefinitionId);
		ProcessEngineConfiguration processEngineConfiguration = processEngine.getProcessEngineConfiguration();
		ProcessDiagramGenerator diagramGenerator = processEngineConfiguration.getProcessDiagramGenerator();
		InputStream in = diagramGenerator.generateDiagram(bpmnModel, "png", "宋体", "宋体", "宋体", null);
		
		OutputStream ous = new FileOutputStream(new File("D://a.png"));
		IOUtils.copy(in, ous);
	}

	@Test
	public void getInstanceFlow() throws IOException{
		String processDefinitionId="process3:1:4";
		String processInstanceId="15001";
		
		BpmnModel bpmnModel = repositoryService.getBpmnModel(processDefinitionId);
		ProcessEngineConfiguration processEngineConfiguration = processEngine.getProcessEngineConfiguration();
		ProcessDiagramGenerator diagramGenerator = processEngineConfiguration.getProcessDiagramGenerator();
		
		//高亮act
		List<String> highLightedActivities=this.getHighLightedActivities(processInstanceId);
		
		//高亮flow
		List<String> highLightedFlows=new ArrayList<>();
		
        InputStream in = diagramGenerator.generateDiagram(bpmnModel, "png", highLightedActivities,highLightedFlows,"宋体","宋体",null,null, 1.0);
        OutputStream ous = new FileOutputStream(new File("D://a.png"));
		IOUtils.copy(in, ous);
	}
	
	@Test
	public List<String> getHighLightedActivities(String processInstanceId){
		List<HistoricActivityInstance> activitys=historyService.createHistoricActivityInstanceQuery().processInstanceId(processInstanceId).orderByHistoricActivityInstanceId().asc().list();
		Set<String> ids=activitys.stream().map(HistoricActivityInstance::getActivityId).collect(Collectors.toSet());
		return new ArrayList<String>(ids);
	}
	
}
