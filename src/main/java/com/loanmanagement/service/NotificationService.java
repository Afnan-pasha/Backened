package com.loanmanagement.service;

import com.loanmanagement.dto.NotificationResponse;
import com.loanmanagement.model.Notification;
import com.loanmanagement.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    public NotificationResponse createNotification(String title, String message,
                                                   Notification.NotificationType type) {
        Notification notification = new Notification(title, message, type);
        Notification savedNotification = notificationRepository.save(notification);
        return new NotificationResponse(savedNotification);
    }

    public List<NotificationResponse> getAllNotifications() {
        List<Notification> notifications = notificationRepository.findAllByOrderByCreatedAtDesc();
        return notifications.stream()
                .map(NotificationResponse::new)
                .collect(Collectors.toList());
    }

    public List<NotificationResponse> getUnreadNotifications() {
        List<Notification> notifications = notificationRepository.findByIsReadOrderByCreatedAtDesc(false);
        return notifications.stream()
                .map(NotificationResponse::new)
                .collect(Collectors.toList());
    }

    public boolean markAsRead(Long notificationId) {
        Optional<Notification> notificationOpt = notificationRepository.findById(notificationId);
        if (notificationOpt.isPresent()) {
            Notification notification = notificationOpt.get();
            notification.setIsRead(true);
            notificationRepository.save(notification);
            return true;
        }
        return false;
    }

    public boolean markAllAsRead() {
        List<Notification> unreadNotifications = notificationRepository.findByIsReadOrderByCreatedAtDesc(false);
        for (Notification notification : unreadNotifications) {
            notification.setIsRead(true);
        }
        notificationRepository.saveAll(unreadNotifications);
        return true;
    }

    public long getUnreadCount() {
        return notificationRepository.countByIsRead(false);
    }

    public boolean deleteNotification(Long notificationId) {
        Optional<Notification> notificationOpt = notificationRepository.findById(notificationId);
        if (notificationOpt.isPresent()) {
            notificationRepository.delete(notificationOpt.get());
            return true;
        }
        return false;
    }
}
