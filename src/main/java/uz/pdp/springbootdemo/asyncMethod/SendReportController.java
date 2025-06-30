package uz.pdp.springbootdemo.asyncMethod;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SendReportController {

    private final ReportSenderService reportSenderService;

    public SendReportController(ReportSenderService reportSenderService) {
        this.reportSenderService = reportSenderService;
    }

    @GetMapping("/sendReport")
    public String report() {
        reportSenderService.sendReport();
        return "Report sent successfully";
    }
}
