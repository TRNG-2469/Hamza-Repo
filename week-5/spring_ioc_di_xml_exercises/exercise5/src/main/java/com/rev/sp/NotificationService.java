package com.rev.sp;

public class NotificationService {
    MessageService messageService;

    public NotificationService(MessageService messageService) {
        this.messageService = messageService;
    }
}