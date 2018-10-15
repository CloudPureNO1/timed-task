package idv.wangyj.javaquartz.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HelloJob implements Job {

    private Thread currentThread=Thread.currentThread();

    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println(currentThread.getName()+currentThread.getId()+">>>>>java quartz 定时任务>>>>>"+new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
    }
}
