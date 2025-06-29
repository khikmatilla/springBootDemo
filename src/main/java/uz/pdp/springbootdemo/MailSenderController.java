package uz.pdp.springbootdemo;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/mail")
public class MailSenderController {

    private final MailSenderService mailSenderService;

    public MailSenderController(MailSenderService mailSenderService) {
        this.mailSenderService = mailSenderService;
    }

    @PostMapping("/simple-mail")
    public String sendSimpleMail(@RequestParam String userName) {
        mailSenderService.sendSimpleMail(userName);
        return "Mail sent successfully";
    }

    @PostMapping("/simple-mailAttachment")
    public String sendAttachmentMail(@RequestParam String userName) {
        mailSenderService.sendAttachmentMail(userName);
        return "Mail sent successfully";
    }

     @PostMapping("/send-imageMail")
    public String sendImageMail(@RequestParam String userName) {
        mailSenderService.sendImgMail(userName);
        return "Mail sent successfully";
    }


}
