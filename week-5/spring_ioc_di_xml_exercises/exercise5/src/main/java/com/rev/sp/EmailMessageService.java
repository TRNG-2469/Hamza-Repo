package com.rev.sp;

public class EmailMessageService implements MessageService {

    @Override
    public void sendMessage(String message) {
        System.out.println("Sending email message: " + message);
    }
}
