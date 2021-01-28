package com.sdstc.flowable.service;

import org.flowable.engine.RepositoryService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.engine.repository.Deployment;
import org.flowable.engine.repository.ProcessDefinition;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.api.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlowableService {
    @Autowired
    private RepositoryService repositoryService;
    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private TaskService taskService;

    public void deployment(String tenantId){
        Deployment deployment = repositoryService.createDeployment().addClasspathResource("holiday.bpmn20.xml").tenantId(tenantId).deploy();
        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery()
                .deploymentId(deployment.getId())
                .processDefinitionTenantId(tenantId)
                .singleResult();
        System.out.println("Found process definition : " + processDefinition.getName());
    }

    public void startInstance(String key,String tenantId){
        ProcessInstance holiday = runtimeService.startProcessInstanceByKeyAndTenantId(key,tenantId);
    }

    public void queryTask(String assignee,String tenantId){
        System.out.println(assignee);
        List<Task> taskList = taskService.createTaskQuery().taskTenantId(tenantId).taskAssignee(assignee).list();
        for(Task task:taskList){
            System.out.println("id:"+task.getId()+",name:"+task.getName());
        }
    }

    public void completeTask(String taskId){
        taskService.complete(taskId);
    }
}
