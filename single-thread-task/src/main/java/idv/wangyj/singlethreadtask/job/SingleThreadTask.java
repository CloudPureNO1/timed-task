package idv.wangyj.singlethreadtask.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class SingleThreadTask {
    private Logger logger = LoggerFactory.getLogger(SingleThreadTask.class);//slf4j+logback 能够输出定时日志的线程池和线程

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    @Scheduled(cron = "0/5 * * * * ?")
    public void singleThreadTask1() {
        logger.info(">>>>>>>>>>>>>>singelThreadTask1>>>>:" + simpleDateFormat.format(new Date()));
    }

    @Scheduled(cron = "0/4 * * * * ?")
    public void singleThreadTask2() {
        logger.info(">>>>>>>>>>>>>>singleThreadTask2>>>>>;" + simpleDateFormat.format(new Date()));
    }
}
