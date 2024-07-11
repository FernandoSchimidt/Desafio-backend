package com.fernandoschimidt.magalusms.controller;

import com.fernandoschimidt.magalusms.dto.ScheduleNotificationDto;
import com.fernandoschimidt.magalusms.entity.Notification;
import com.fernandoschimidt.magalusms.service.NotificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping
    public ResponseEntity<Void> scheduleNotification(@RequestBody ScheduleNotificationDto dto) {
        notificationService.scheduleNotification(dto);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/{notificationId}")
    public ResponseEntity<Notification> getNotification(@PathVariable(name = "notificationId") Long notificationId) {
        var notification = notificationService.findById(notificationId);

        if (notification.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(notification.get());
    }

    @DeleteMapping("/{notificationId}")
    public ResponseEntity<Void> cancelNotification(@PathVariable(name = "notificationId") Long notificationId) {
        notificationService.calcelNotification(notificationId);
        return ResponseEntity.noContent().build();
    }
}
