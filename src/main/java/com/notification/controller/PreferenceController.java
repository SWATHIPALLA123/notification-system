package com.notification.controller;
 
import com.notification.dto.PreferenceRequestDTO;
import com.notification.entity.NotificationPreference;
import com.notification.service.PreferenceService;
 
import org.springframework.web.bind.annotation.*;
 
import java.util.List;
 
@RestController
@RequestMapping("/preferences")
public class PreferenceController {
 
    private final PreferenceService service;
 
    public PreferenceController(PreferenceService service) {
        this.service = service;
    }
 
    // UPSERT (CREATE / UPDATE)
    @PutMapping("/{userId}")
    public NotificationPreference update(
            @PathVariable Long userId,
            @RequestBody PreferenceRequestDTO dto) {
 
        return service.update(userId, dto);
    }
 
    // GET BY USER
    @GetMapping("/{userId}")
    public List<NotificationPreference> get(@PathVariable Long userId) {
        return service.getByUser(userId);
    }
}
 