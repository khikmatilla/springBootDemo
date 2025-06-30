package uz.pdp.springbootdemo.asyncMethod;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
@Slf4j
public class ReportSenderService {

    @Async
    public void sendReport() {
        try{
            TimeUnit.SECONDS.sleep(5);
        }
        catch(Exception e){}

        log.info("Report Send");
    }
}
