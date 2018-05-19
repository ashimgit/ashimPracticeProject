package quartz.test;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class CronTriggerExample {
	public static void main(String[] args) {
		JobDetail jobDetail=JobBuilder.newJob(HelloJob.class).withIdentity("jobName", "group1").build();
		Trigger trigger=TriggerBuilder.newTrigger().withIdentity("Trigger1", "group1").withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ?")).build();
		
		try {
			Scheduler scheduler=new StdSchedulerFactory().getScheduler();
			scheduler.start();
			scheduler.scheduleJob(jobDetail, trigger);
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
