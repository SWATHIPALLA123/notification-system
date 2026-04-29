package com.notification.dto;
 
import com.notification.enums.NotificationType;
 
public class NotificationRequestDTO {
 
    private Long userId;
    private NotificationType type;
    private String message;
 
    // Getters & Setters
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
 
    public NotificationType getType() { return type; }
    public void setType(NotificationType type) { this.type = type; }
 
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}
 