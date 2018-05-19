package quartz.test;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class HelloJob implements Job{

	int cnt=0;
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		System.out.println("Hello Quartz : Count : "+cnt);
		
	}

}
