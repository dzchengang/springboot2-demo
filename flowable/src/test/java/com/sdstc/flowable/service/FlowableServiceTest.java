package com.sdstc.flowable.service;

import com.sdstc.FlowableStart;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = FlowableStart.class)
public class FlowableServiceTest {
    @Autowired
    private FlowableService flowableService;

    @Test
    public void testDeployment(){
        flowableService.deployment("1");
    }

    @Test
    public void testStartInstance(){
        flowableService.startInstance("holiday","1");
    }
    @Test
    public void testQueryTask(){
        flowableService.queryTask("sunk","1");
        flowableService.queryTask("hanql","1");
    }
    @Test
    public void testComplateTask(){
        flowableService.completeTask("ba270cc3-5863-11eb-a7ae-005056c00008");
    }
}