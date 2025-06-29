package uz.pdp.springbootdemo;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@Configuration
public class SchedulerTask {

    // 5-54/3 * * * * * very 3 seconds between 5 and 54
    @Scheduled(cron = "* 0 20 LW * *", zone = "Asia/Tashkent")
    public void scheduledTask() {
        System.out.println("(Cron every second) Time is " + new Date());
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
   // @Scheduled(fixedDelay = 1, timeUnit = TimeUnit.SECONDS)
    public void fixedDelayTask() {
        System.out.println("(Cron every second) Time is " + new Date());
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }//fixedDelay har bir sekundda ishlidi toki try ni ichidigi ish tugashini poylidi
    }
 //@Scheduled(fixedRate = 1, timeUnit = TimeUnit.SECONDS)
    public void fixedRateTask() {
        System.out.println("(Cron every second) Time is " + new Date());
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }//fixedRate har bir sekundda ishlidi try ni ichidigi ish unga qiziq emas
    }

}
