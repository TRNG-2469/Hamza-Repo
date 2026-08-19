package com.rev.sp;

public class SMSMessageService implements MessageService {
    @Override
    public void sendMessage(String message) {
        System.out.println("SMSMessageService " + message);
    }
}