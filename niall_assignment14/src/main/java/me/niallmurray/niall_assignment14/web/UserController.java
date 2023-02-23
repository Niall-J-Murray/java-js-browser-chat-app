package me.niallmurray.niall_assignment14.web;

import me.niallmurray.niall_assignment14.domain.User;
import me.niallmurray.niall_assignment14.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  @Autowired
  private UserService userService;

  @PostMapping("/register")
  public User createUser (@RequestBody String name) {
    return userService.createUser(name);
  }

}