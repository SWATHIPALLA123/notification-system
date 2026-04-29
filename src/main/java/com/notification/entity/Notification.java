package com.notification.entity;
 
import com.notification.enums.NotificationStatus;
import com.notification.enums.NotificationType;
import jakarta.persistence.*;
 
@Entity
public class Notification {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 
    private Long userId;
 
    @Enumerated(EnumType.STRING)
    private NotificationType type;
 
    private String message;
 
    @Enumerated(EnumType.STRING)
    private NotificationStatus status;
 
    // Getters & Setters
    public Long getId() { return id; }
 
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
 
    public NotificationType getType() { return type; }
    public void setType(NotificationType type) { this.type = type; }
 
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
 
    public NotificationStatus getStatus() { return status; }
    public void setStatus(NotificationStatus status) { this.status = status; }
}
 