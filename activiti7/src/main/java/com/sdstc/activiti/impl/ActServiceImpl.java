package com.sdstc.activiti.impl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdstc.activiti.ActService;

import lombok.extern.log4j.Log4j2;

/**
 * 
 * @author cheng
 *
 */
@Service("actService")
@Log4j2
public class ActServiceImpl implements ActService {
	@Autowired
	private RuntimeService runtimeService;
	@Autowired
	private RepositoryService repositoryService;
	@Autowired
	private TaskService taskService;

	@Override
	public Deployment deploment(String resourceName, String depName,String content, String tenantId) throws FileNotFoundException, IOException {
		DeploymentBuilder builder = repositoryService.createDeployment();
		
		content = content.replaceAll("camunda:assignee=", "activiti:assignee=");
		content = content.replaceAll("camunda:candidateUsers=", "activiti:candidateUsers=");
		content = content.replaceAll("camunda:candidateGroups=", "activiti:candidateGroups=");
		content = content.replaceAll("camunda:properties", "activiti:properties");
		content = content.replaceAll("camunda:collection", "activiti:collection");
		content = content.replaceAll("camunda:elementVariable", "activiti:elementVariable");
		
		
		builder.name(depName + ".bpmn");
		builder.tenantId(tenantId);
		builder.addString(depName + ".bpmn", content);
		return builder.deploy();

	}

	@Override
	public ProcessInstance startProcess(String processDefinitionKey, Map<String, Object> variables, String tenantId) {
		// ProcessInstance instance
		// =runtimeService.startProcessInstanceById(processDefinitionKey, variables);
		ProcessInstance instance = runtimeService.startProcessInstanceByKeyAndTenantId(processDefinitionKey, variables, tenantId);
		return instance;
	}

	@Override
	public void complateTask(String taskId, Map<String, Object> variables, String tenantId) {
		Task task = taskService.createTaskQuery().taskTenantId(tenantId).taskId(taskId).singleResult();

		if (task != null) {
			taskService.complete(taskId, variables);
		}
	}

	@Override
	public void complateTask(String taskId, Map<String, Object> variables) {
		taskService.complete(taskId, variables);
	}

	
}
