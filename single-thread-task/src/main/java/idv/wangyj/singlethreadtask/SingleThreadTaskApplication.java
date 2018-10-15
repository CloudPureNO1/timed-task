package idv.wangyj.singlethreadtask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling//开启springboot 定时任务
public class SingleThreadTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(SingleThreadTaskApplication.class, args);
    }
}
