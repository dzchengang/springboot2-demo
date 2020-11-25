package com.sdstc.service.transtional.impl;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

@DisallowConcurrentExecution
public class MyJob extends QuartzJobBean{
	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		System.out.println("我开始干活啦"+context.getJobDetail().getJobDataMap().getString("a"));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("我干完活啦");
		
	}

}
