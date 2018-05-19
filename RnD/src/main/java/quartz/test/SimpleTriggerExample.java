package quartz.test;

import javax.swing.JProgressBar;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class SimpleTriggerExample {
	public static void main(String[] args) {
		JobDetail jobDetail = JobBuilder.newJob(HelloJob.class).withIdentity("DummyJobName", "group1").build();
		Trigger trig = TriggerBuilder.newTrigger().withIdentity("DummyTrigName", "group1")
				.withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5).repeatForever()).build();
		Scheduler scheduler=null;
		try {
			scheduler=new StdSchedulerFactory().getScheduler();
			scheduler.start();
			scheduler.scheduleJob(jobDetail, trig);
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
