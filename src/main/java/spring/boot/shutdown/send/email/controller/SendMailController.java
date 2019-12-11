package spring.boot.shutdown.send.email.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import spring.boot.shutdown.send.email.service.MailService;

import javax.validation.constraints.NotBlank;

/**
 * @author: 程泰恒
 * @date: 2019/12/4 13:30
 */

@Slf4j
@RestController
@Validated
public class SendMailController {

    private final static String SUBJECT = "警告";

    private final static String CONTEXT = "您的项目已下线，如果并非是您本人操作，有被黑的风险，请查明情况";

    @Autowired
    private MailService mailService;

    @PostMapping("/send-mail")
    public String sendMail(@NotBlank @RequestParam("title") String title,@NotBlank @RequestParam("context") String context) {
        mailService.sendSimpleMail("chth668@163.com", title, context);
        return "success";
    }

}
