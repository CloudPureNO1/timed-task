package idv.wangyj.dynamiccrontask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DynamicCronTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(DynamicCronTaskApplication.class, args);
    }
}
