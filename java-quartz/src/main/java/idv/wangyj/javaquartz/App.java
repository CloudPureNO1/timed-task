package idv.wangyj.javaquartz;

import idv.wangyj.javaquartz.job.HelloJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;


public class App {


    public static void main(String []args){

        try {
            //工厂，创建quartz 定时任务调度器
            Scheduler scheduler=StdSchedulerFactory.getDefaultScheduler();
            //启动任务调度器
            scheduler.start();
            System.out.println("》》》》》调度器"+scheduler.getSchedulerName()+"启动》》》》》》");


            //具体任务
            JobDetail jobDetail=JobBuilder.newJob(HelloJob.class).withIdentity("job1","group1").build();

            //设置触发时间，2秒触发一次
           SimpleScheduleBuilder simpleScheduleBuilder= SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).repeatForever();

           //实例化触发器
           Trigger trigger= TriggerBuilder.newTrigger()
                    .withIdentity("trigger1","group1")
                    .startNow()
                    .withSchedule(simpleScheduleBuilder)
                    .build();

           //任务调度器调度任务
            scheduler.scheduleJob(jobDetail,trigger);

            //关闭 任务调度器
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
