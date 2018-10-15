package idv.wangyj.springbootquartz.job.config;

import idv.wangyj.springbootquartz.job.HelloJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfig {
    @Bean
    public JobDetail jobDetail(){
        return JobBuilder.newJob(HelloJob.class).withIdentity("job1","group1").storeDurably().build();
    }

    @Bean
    public Trigger trigger(){
        SimpleScheduleBuilder simpleScheduleBuilder=SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).repeatForever();
        Trigger trigger=TriggerBuilder.newTrigger().forJob(jobDetail()).withIdentity("trigger1","group1")
                .withSchedule(simpleScheduleBuilder).build();
        return trigger;
    }
}
