package idv.wangyj.javaquartz2.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HelloJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        Thread thread=Thread.currentThread();
        System.out.println(">>>>>>java-quartz2>>"+thread.getName()+thread.getId()+">>>>"+new SimpleDateFormat("yyyy-mm-dd hh:mm:ss").format(new Date()));
    }
}
