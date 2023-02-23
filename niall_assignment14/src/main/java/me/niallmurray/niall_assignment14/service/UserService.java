package me.niallmurray.niall_assignment14.service;

import me.niallmurray.niall_assignment14.domain.User;
import me.niallmurray.niall_assignment14.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser (String name) {
        User user = new User();
        user.setUsername(name);
        return userRepository.save(user);
    }
}