 package com.notification.service;
 
import com.notification.dto.NotificationRequestDTO;
import com.notification.entity.Notification;
import com.notification.entity.NotificationPreference;
import com.notification.entity.User;
import com.notification.enums.NotificationStatus;
import com.notification.enums.NotificationType;
import com.notification.exception.ResourceNotFoundException;
import com.notification.repository.NotificationRepository;
import com.notification.repository.PreferenceRepository;
import com.notification.repository.UserRepository;
 
import org.springframework.stereotype.Service;
 
import java.util.List;
import java.util.Optional;
 
@Service
public class NotificationService {
 
    private final NotificationRepository notificationRepo;
    private final PreferenceRepository preferenceRepo;
    private final UserRepository userRepo;
 
    // Constructor Injection
    public NotificationService(NotificationRepository notificationRepo,
                               PreferenceRepository preferenceRepo,
                               UserRepository userRepo) {
        this.notificationRepo = notificationRepo;
        this.preferenceRepo = preferenceRepo;
        this.userRepo = userRepo;
    }
 
    // =========================
    // SEND NOTIFICATION
    // =========================
    public Notification send(NotificationRequestDTO dto) {
 
        // 1. Check if user exists
        User user = userRepo.findById(dto.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
 
        // 2. Create notification
        Notification notification = new Notification();
        notification.setUserId(user.getId());
        notification.setType(dto.getType());
        notification.setMessage(dto.getMessage());
 
        // 3. Check user preference
        Optional<NotificationPreference> prefOpt =
                preferenceRepo.findByUserIdAndType(dto.getUserId(), dto.getType());
 
        if (prefOpt.isPresent() && prefOpt.get().isEnabled()) {
            notification.setStatus(NotificationStatus.SENT);
        } else {
            notification.setStatus(NotificationStatus.FAILED);
        }
 
        // 4. Save (always save as per business rule)
        return notificationRepo.save(notification);
    }
 
    // =========================
    // GET ALL NOTIFICATIONS
    // =========================
    public List<Notification> getAll() {
        return notificationRepo.findAll();
    }
 
    // =========================
    // GET BY USER
    // =========================
    public List<Notification> getByUser(Long userId) {
        return notificationRepo.findByUserId(userId);
    }
 
    // =========================
    // GET BY STATUS
    // =========================
    public List<Notification> getByStatus(NotificationStatus status) {
        return notificationRepo.findByStatus(status);
    }
 
    // =========================
    // GET BY TYPE
    // =========================
    public List<Notification> getByType(NotificationType type) {
        return notificationRepo.findByType(type);
    }
}
 