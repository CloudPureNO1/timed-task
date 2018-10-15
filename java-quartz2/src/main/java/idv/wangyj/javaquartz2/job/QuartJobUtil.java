package idv.wangyj.javaquartz2.job;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class QuartJobUtil {
    public static void startJob(){
        try {
            //工厂，创建quartz 定时任务调度器
            Scheduler scheduler=StdSchedulerFactory.getDefaultScheduler();
            //启动任务调度器
            scheduler.start();
            System.out.println("》》》》》调度器"+scheduler.getSchedulerName()+"启动》》》》》》");


            //具体任务
            JobDetail jobDetail=JobBuilder.newJob(HelloJob.class)
                    //.withIdentity("job1","group1")
                    .withIdentity("myJob")  //标识id
                    .build();

            //设置触发时间，2秒触发一次
            SimpleScheduleBuilder simpleScheduleBuilder= SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).repeatForever();

            //实例化触发器
            Trigger trigger= TriggerBuilder.newTrigger()
                   // .withIdentity("trigger1","group1")
                    .withIdentity("myJob-triiger") //标识id
                    .startNow()
                    .withSchedule(simpleScheduleBuilder)
                    .build();

            //任务调度器调度任务
            scheduler.scheduleJob(jobDetail,trigger);
            //任务执行完成后关闭任务调度器
            Thread.sleep(50000);//睡眠50秒
            scheduler.shutdown();
            System.out.println("》》》》》调度器"+scheduler.getSchedulerName()+"关闭》》》》》》");
        } catch (SchedulerException e) {
            System.out.println("》》》》》调度器创建异常：》》》》》》"+e.getMessage() );
            e.printStackTrace();
        } catch (InterruptedException e) {
            System.out.println("》》》》》Thread睡眠异常：》》》》》》"+e.getMessage());
            e.printStackTrace();
        }
    }
}
