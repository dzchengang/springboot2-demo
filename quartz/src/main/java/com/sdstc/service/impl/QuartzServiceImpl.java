package com.sdstc.service.impl;

import org.quartz.CronScheduleBuilder;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdstc.service.QuartzService;

@Service("quartzService")
public class QuartzServiceImpl implements QuartzService {
	@Autowired
	private Scheduler scheduler;

	@Override
	public boolean addJob(String jobName,String groupName,String triggerName, String cron, Class<? extends Job> jobClazz) throws SchedulerException {
		if (this.isExist(jobName,groupName)) {
			return false;
		} else {
			JobDetail job = JobBuilder.newJob(jobClazz).withIdentity(jobName,groupName).build();
			job.getJobDataMap().put("a", "b");
			CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cron);
			Trigger trigger = TriggerBuilder.newTrigger().withIdentity(triggerName,groupName).withSchedule(scheduleBuilder).build();
			scheduler.scheduleJob(job, trigger);
			return true;
		}
	}

	@Override
	public void pauseJob(String jobName,String groupName) throws SchedulerException {
		scheduler.pauseJob(new JobKey(jobName, groupName));
	}

	@Override
	public void startJob(String jobName,String groupName) throws SchedulerException {
		scheduler.resumeJob(new JobKey(jobName, groupName));
	}

	@Override
	public boolean isExist(String jobName,String groupName) throws SchedulerException {
		return scheduler.checkExists(new JobKey(jobName, groupName));
	}

	@Override
	public void removeJob(String jobName,String groupName) throws SchedulerException {
		scheduler.deleteJob(new JobKey(jobName, groupName));
	}

}
