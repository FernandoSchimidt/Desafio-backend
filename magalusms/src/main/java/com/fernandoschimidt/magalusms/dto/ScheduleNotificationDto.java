package com.fernandoschimidt.magalusms.dto;

import com.fernandoschimidt.magalusms.entity.Channel;
import com.fernandoschimidt.magalusms.entity.Notification;
import com.fernandoschimidt.magalusms.entity.Status;

import java.time.LocalDateTime;

public record ScheduleNotificationDto(
        LocalDateTime dateTime,
        String destination,
        String message,
        Channel.Values channel
) {
    public Notification toNotification() {
        return new Notification(
                dateTime,
                destination,
                message,
                channel.toChannel(),
                Status.Values.PENDING.toStatus()
        );
    }
}
