package spring.boot.shutdown.send.email;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import spring.boot.shutdown.send.email.service.MailService;
import spring.boot.shutdown.send.email.service.MailServiceImpl;

import javax.annotation.PreDestroy;
import java.io.UnsupportedEncodingException;

/**
 * @author: 程泰恒
 * @date: 2019/12/3 16:19
 */

@SpringBootApplication
public class ShutdownSendEmailApplication {

    private static MailService mailService = new MailServiceImpl();

    public static void main(String[] args) throws UnsupportedEncodingException {
        SpringApplication.run(ShutdownSendEmailApplication.class, args);
    }

}
