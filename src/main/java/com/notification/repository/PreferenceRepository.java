package com.notification.repository;
 
import com.notification.entity.NotificationPreference;
import com.notification.enums.NotificationType;
import org.springframework.data.jpa.repository.JpaRepository;
 
import java.util.List;
import java.util.Optional;
 
public interface PreferenceRepository extends JpaRepository<NotificationPreference, Long> {
 
    List<NotificationPreference> findByUserId(Long userId);
 
    Optional<NotificationPreference> findByUserIdAndType(Long userId, NotificationType type);
}
 