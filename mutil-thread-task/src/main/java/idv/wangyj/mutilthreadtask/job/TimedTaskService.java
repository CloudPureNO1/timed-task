package idv.wangyj.mutilthreadtask.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * spring boot 定时任务的日志输出，采用slf4j+logback 可以输出线程池和线程
 */
@Component
public class TimedTaskService {
    private Logger logger=LoggerFactory.getLogger(TimedTaskService.class);//slf4j+logback 可以输出线程池和线程

    private SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    @Scheduled(cron = "0/5 * * * * ?")
    public void timedTask1(){
        logger.info(">>>>>timedTask1>>>>>"+simpleDateFormat.format(new Date()));
    }

    @Scheduled(cron = "0/3 * * * * ?")
    public void timedTask2(){
        logger.info("*****timedTask2*****"+simpleDateFormat.format(new Date()));
    }

    @Scheduled(cron="0/1 * * * * ?")
    public void timedTask3(){
        logger.info("=====timedTask3====="+simpleDateFormat.format(new Date()));
    }
}
