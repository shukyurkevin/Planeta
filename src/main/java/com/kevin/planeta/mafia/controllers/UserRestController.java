package com.kevin.planeta.mafia.controllers;

import com.kevin.planeta.mafia.interfaces.ServiceInterface;
import com.kevin.planeta.mafia.models.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserRestController {

  private final ServiceInterface<User, Long> userService;

  @Autowired
  public UserRestController(ServiceInterface<User, Long> userService) {
    this.userService = userService;
  }

  @GetMapping("/allUsers")
  public List<User> getAllUsers() {
    return userService.findAll();
  }

  @GetMapping("/userById/{id}")
  public User getUserById(@PathVariable(name = "id") Long id) {
    return userService.findById(id)
        .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
  }

  @PostMapping("/newUser")
  public User createUser(@RequestBody User user) {
    return userService.save(user);
  }
  @PostMapping("/updateUser/{id}")
  public User updateUser(@PathVariable(name = "id") Long id, @RequestBody User user) {
    return userService.update(id, user);
  }

}
