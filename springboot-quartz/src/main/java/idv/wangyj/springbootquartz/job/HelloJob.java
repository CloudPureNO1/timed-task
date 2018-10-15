package idv.wangyj.springbootquartz.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HelloJob extends QuartzJobBean {
    private Logger log=LoggerFactory.getLogger(HelloJob.class);
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info(">>>>>>>>>>>>>>>>>>>>>>quartz springboot job >>>>>>>>>>>>"+new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
    }
}
