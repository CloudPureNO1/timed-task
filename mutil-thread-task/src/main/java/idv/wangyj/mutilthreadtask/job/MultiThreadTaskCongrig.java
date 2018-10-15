package idv.wangyj.mutilthreadtask.job;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.concurrent.Executors;


/**
 * springboot 定时任务默认是单线程的，要实现多线程 只要添加一个实现  SchedulingConfigurer 的 configureTasks 方法打配置类
 * @see SchedulingConfigurer
 * @see Executors
 * @author 王源骏
 * @version 1.0.0
 */
@Configuration
public class MultiThreadTaskCongrig implements SchedulingConfigurer {
    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.setScheduler(Executors.newScheduledThreadPool(5));//5个线程
    }
}
