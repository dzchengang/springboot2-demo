package com.sdstc.controller;

import java.util.HashMap;
import java.util.Map;

import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sdstc.service.QuartzService;
import com.sdstc.service.impl.MyJob;

@RestController
@RequestMapping("/")
public class PubController {
    
	@Autowired
	private QuartzService quartzService;
	
	
	@GetMapping("/test")
	public Map<String, String> sendReq(Integer test) throws SchedulerException {
		if(test==1) {
			quartzService.addJob("myJob", "group1", "trigger1", "0/2 * * * * ?", MyJob.class);
		}else if(test==2) {
			quartzService.startJob("myJob", "group1");
		}else if(test==3) {
			quartzService.pauseJob("myJob", "group1");
		}else if(test==4) {
			quartzService.removeJob("myJob", "group1");
		}else if(test==5) {
			
		}
		
		
		Map<String, String> result = new HashMap<String, String>();
		result.put("x", "y");
		return result;
	}
}
