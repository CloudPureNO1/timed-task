package idv.wangyj.springbootquartz2.job.config;

import idv.wangyj.springbootquartz2.job.HelloJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * springboot-quart 定时任务需要{@link org.quartz.JobDetail} 、{@link org.quartz.Trigger}
 * 调度器交由springboot,所以不需注册调度器的bean  {@link org.quartz.Scheduler}
 */
@Configuration
public class QuartConfig {


    /**
     * 注册  JobDetail bean
     * @return
     */
    @Bean
    public JobDetail jobDetail(){
        return JobBuilder.newJob(HelloJob.class)
                .withIdentity("myjob")
                .storeDurably()  //即使没有Trigger关联时，也不删除job
                .build();
    }


    /**
     * 注册 Trigger bean
     * @return
     */
    @Bean
    public Trigger trigger(){
        return TriggerBuilder.newTrigger()
                .forJob(jobDetail())
                .withIdentity("myjob-trigger")  //标识id
                .startNow()
                .withSchedule(getScheduleBuilder())
                .build();
    }

    /**
     * 调度器规则
     * @return
     */
    private SimpleScheduleBuilder getScheduleBuilder(){
        return SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(2) //2秒执行一次
                .repeatForever();
    }
}
