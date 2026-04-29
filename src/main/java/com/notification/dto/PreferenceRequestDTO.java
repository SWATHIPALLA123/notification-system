package com.notification.dto;
 
import com.notification.enums.NotificationType;
 
public class PreferenceRequestDTO {
 
    private NotificationType type;
    private boolean enabled;
 
    public NotificationType getType() {
        return type;
    }
 
    public void setType(NotificationType type) {
        this.type = type;
    }
 
    public boolean isEnabled() {
        return enabled;
    }
 
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
 