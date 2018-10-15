package idv.wangyj.springbootquartz2.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * spring boot 集成quartz, 任务类继承 QuartzJobBean
 * @see QuartzJobBean
 */
public class HelloJob extends QuartzJobBean {

    private Logger log=LoggerFactory.getLogger(HelloJob.class);
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info(">>>>>>>>>>>>springboot-quartz2>>>>>>>"+new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
    }
}
