package uz.pdp.springbootdemo;

import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;

@Component
public class MailSenderService {

    private final JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String from;

    public MailSenderService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Async
    public void sendSimpleMail(String userName) {
        try{
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();

            mimeMessage.setFrom(new InternetAddress(from));
            mimeMessage.setRecipients(Message.RecipientType.TO, String.valueOf(new InternetAddress("otkirbekovamadinabonu@gmail.com")));
            mimeMessage.setSubject("Simple Mail");
            mimeMessage.setText("Simple Mail Body is here");

            javaMailSender.send(mimeMessage);
        }
        catch (MessagingException e){
            e.printStackTrace();
        }
    }

    @Async
    public void sendAttachmentMail(String userName) {
        try{
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom(new InternetAddress(from));
            mimeMessageHelper.setTo(new InternetAddress("otkirbekovamadinabonu@gmail.com"));
            mimeMessage.setSubject("Simple Mail");

            Path path = Path.of("src/main/resources/activate.html");
            Path imagePath = Path.of("src/main/resources/textRotate.jpg");
            Path pdfPath = Path.of("src/main/resources/individual loyiha habibullayev.pdf");
            FileSystemResource imgSystemResource = new FileSystemResource(imagePath);
            FileSystemResource pdfSystemResource = new FileSystemResource(pdfPath);
            String htmlMailContent = Files.readString(path);
            htmlMailContent = htmlMailContent.formatted(userName);

            mimeMessageHelper.setText(htmlMailContent, true);
            mimeMessageHelper.addAttachment("image.png", imgSystemResource);
            mimeMessageHelper.addAttachment("indivudal loyiha.pdf", pdfSystemResource);

            javaMailSender.send(mimeMessage);
        }
        catch (MessagingException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Async
    public void sendImgMail(String userName) {
        try{
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom(new InternetAddress(from));
            mimeMessageHelper.setTo(new InternetAddress("otkirbekovamadinabonu@gmail.com"));
            mimeMessage.setSubject("Simple Mail");

            Path path = Path.of("src/main/resources/activate.html");
            Path imagePath = Path.of("src/main/resources/textRotate.jpg");
            Base64.Encoder encoder = Base64.getEncoder();
            String imageAsBase64 = encoder.encodeToString(Files.readAllBytes(imagePath));
            String htmlMailContent = Files.readString(path);
            htmlMailContent = htmlMailContent.formatted(imageAsBase64);

            mimeMessageHelper.setText(htmlMailContent, true);
            javaMailSender.send(mimeMessage);
        }
        catch (MessagingException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
