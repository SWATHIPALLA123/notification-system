package com.notification.entity;
 
import com.notification.enums.NotificationType;
import jakarta.persistence.*;
 
@Entity
@Table(name = "notification_preference")
public class NotificationPreference {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 
    private Long userId;
 
    @Enumerated(EnumType.STRING)
    private NotificationType type;
 
    private boolean enabled;
 
    // getters & setters
    public Long getId() { return id; }
 
    public Long getUserId() { return userId; }
 
    public void setUserId(Long userId) { this.userId = userId; }
 
    public NotificationType getType() { return type; }
 
    public void setType(NotificationType type) { this.type = type; }
 
    public boolean isEnabled() { return enabled; }
 
    public void setEnabled(boolean enabled) { this.enabled = enabled; }
}
 