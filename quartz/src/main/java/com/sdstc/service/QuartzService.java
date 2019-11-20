package com.sdstc.service;

import org.quartz.Job;
import org.quartz.SchedulerException;

public interface QuartzService {
   boolean addJob(String jobName,String groupName,String triggerName,String cron,Class<? extends Job> jobClazz)throws SchedulerException;
   void removeJob(String jobName,String groupName)throws SchedulerException;
   void pauseJob(String jobName,String groupName)throws SchedulerException;
   void startJob(String jobName,String groupName)throws SchedulerException;
   boolean isExist(String jobName,String groupName)throws SchedulerException;
}
