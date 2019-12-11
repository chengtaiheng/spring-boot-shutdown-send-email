package spring.boot.shutdown.send.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import spring.boot.shutdown.send.email.service.MailService;

import java.io.UnsupportedEncodingException;

/**
 * @author: 程泰恒
 * @date: 2019/12/4 13:55
 */

@Component
public class ApplicationHookCnf implements ApplicationRunner {

    private static String SUBJECT = "";

    private static String CONTEXT = "";


    static {
        try {
            SUBJECT = new String("警告".getBytes("gbk"),"utf-8");
            CONTEXT = new String("您的项目已下线，如果并非是您本人操作，有被黑的风险，请查明情况。".getBytes("gbk"),"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }


    @Autowired
    private MailService mailService;

    public void run(ApplicationArguments args) throws Exception {
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                mailService.sendSimpleMail("chth668@163.com", SUBJECT, CONTEXT);
            }
        });
    }
}
