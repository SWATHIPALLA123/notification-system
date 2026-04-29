package com.notification.service;
 
import com.notification.dto.PreferenceRequestDTO;
import com.notification.entity.NotificationPreference;
import com.notification.enums.NotificationType;
import com.notification.repository.PreferenceRepository;
 
import org.springframework.stereotype.Service;
 
import java.util.List;
import java.util.Optional;
 
@Service
public class PreferenceService {
 
    private final PreferenceRepository preferenceRepo;
 
    public PreferenceService(PreferenceRepository preferenceRepo) {
        this.preferenceRepo = preferenceRepo;
    }
 
    // ✅ CREATE / UPDATE (UPSERT)
    public NotificationPreference update(Long userId, PreferenceRequestDTO dto) {
 
        Optional<NotificationPreference> existing =
                preferenceRepo.findByUserIdAndType(userId, dto.getType());
 
        NotificationPreference pref;
 
        if (existing.isPresent()) {
            // UPDATE
            pref = existing.get();
            pref.setEnabled(dto.isEnabled());
        } else {
            // CREATE
            pref = new NotificationPreference();
            pref.setUserId(userId);
            pref.setType(dto.getType());
            pref.setEnabled(dto.isEnabled());
        }
 
        return preferenceRepo.save(pref);
    }
 
    // ✅ GET BY USER
    public List<NotificationPreference> getByUser(Long userId) {
        return preferenceRepo.findByUserId(userId);
    }
}