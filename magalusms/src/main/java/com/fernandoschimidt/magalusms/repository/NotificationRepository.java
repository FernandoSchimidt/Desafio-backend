package com.fernandoschimidt.magalusms.repository;

import com.fernandoschimidt.magalusms.entity.Notification;
import com.fernandoschimidt.magalusms.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findByStatusInAndDateTimeBefore(List<Status> status, LocalDateTime dateTime);
}
