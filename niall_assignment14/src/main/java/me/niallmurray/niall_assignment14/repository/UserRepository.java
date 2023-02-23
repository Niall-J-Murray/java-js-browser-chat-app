package me.niallmurray.niall_assignment14.repository;

import me.niallmurray.niall_assignment14.domain.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
  private List<User> users = new ArrayList<>();

  public User save(User user) {
    user.setUserId((long) (users.size() + 1));
    users.add(user);
    return user;
  }
}
