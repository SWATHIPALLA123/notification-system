package com.notification.service;
 
import com.notification.entity.User;
import com.notification.repository.UserRepository;
import org.springframework.stereotype.Service;
 
import java.util.List;
 
@Service
public class UserService {
 
    private final UserRepository repo;
 
    public UserService(UserRepository repo) {
        this.repo = repo;
    }
 
    public User create(User user) {
        return repo.save(user);
    }
 
    public List<User> getAll() {
        return repo.findAll();
    }
 
    public User getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id " + id));
    }
     
    }

  