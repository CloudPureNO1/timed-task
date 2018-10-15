package idv.wangyj.dynamiccrontask.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 要动态取cron或改变 cron，需要实现{@link SchedulingConfigurer} 的 configureTasks 方法
 * 不在需要{@code @Scheduled 注解}
 */
@Component
public class DynamicTaskCronService implements SchedulingConfigurer {
    private  String cron;

    /**
     * 采用slf4j+logback 输出日志，因为可以输出对应的线程池和线程，
     * 如果用log4j 需要自己手动输出线程：
     * Thread currentThread=Thread.currentThread();
     * currentThread.getName()+currentThread.getId()
     * @see Thread
     */
    private Logger logger=LoggerFactory.getLogger(DynamicTaskCronService.class);

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.addTriggerTask(getRunnable(),getTrigger());
    }

    private Runnable getRunnable(){
        return new Runnable() {
            @Override
            public void run() {
                logger.info(">>>>>动态改变cron或动态取值的corn:定时任务："+new SimpleDateFormat("yyyy-MM-dd hh:mm:ss")
                        .format(new Date()));
                //任务逻辑处理代码
            }
        };
    }

    private Trigger getTrigger(){
        return new Trigger() {
            @Override
            public Date nextExecutionTime(TriggerContext triggerContext) {
                setCron();//动态取cron 设置cron
                CronTrigger cronTrigger=new CronTrigger(cron);//配置定时任务 cron
                return cronTrigger.nextExecutionTime(triggerContext);
            }
        };
    }

    /**
     * 动态取cron 或调整cron
     * 1、比如：从Redis中取
     * 2、从其他地方的配置文件取
     * 3、其他
     */
    private void setCron(){
        //常说的整点是一个近似值，一般指 从整点到整点后1分钟之内
        String mmDate=new SimpleDateFormat("ss").format(new Date());
        Thread currentThread=Thread.currentThread();
        System.out.println("------------"+currentThread.getName()+"-----"+currentThread.getId()+"---当前秒："+mmDate+"------当前corn："+cron);
        if(Integer.parseInt(mmDate)>=30){
            cron="0/2 * * * * ?";
        }else{
            cron="0/5 * * * * ?";
        }
    }
}
