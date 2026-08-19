package com.rev.sp;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        // Main method implementation
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        NotificationService ems = context.getBean("notificationService", NotificationService.class);
        ems.messageService.sendMessage("emailMessageService");
        NotificationService sms = context.getBean("notificationService", NotificationService.class);
        sms.messageService.sendMessage("smsMessageService");
        context.close();
    }
}
