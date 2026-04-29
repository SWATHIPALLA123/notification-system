package com.notification.controller;
 
import com.notification.dto.NotificationRequestDTO;
import com.notification.entity.Notification;
import com.notification.enums.NotificationStatus;
import com.notification.enums.NotificationType;
import com.notification.service.NotificationService;
import org.springframework.web.bind.annotation.*;
 
import java.util.List;
 
@RestController
@RequestMapping("/notifications")
public class NotificationController {
 
    private final NotificationService service;
 
    public NotificationController(NotificationService service) {
        this.service = service;
    }
 
    @PostMapping
    public Notification send(@RequestBody NotificationRequestDTO dto) {
        return service.send(dto);
    }
 
    @GetMapping
    public List<Notification> getAll() {
        return service.getAll();
    }
 
    @GetMapping("/user/{userId}")
    public List<Notification> getByUser(@PathVariable Long userId) {
        return service.getByUser(userId);
    }
 
    @GetMapping("/status/{status}")
    public List<Notification> getByStatus(@PathVariable NotificationStatus status) {
        return service.getByStatus(status);
    }
 
    @GetMapping("/type/{type}")
    public List<Notification> getByType(@PathVariable NotificationType type) {
        return service.getByType(type);
    }
}
 