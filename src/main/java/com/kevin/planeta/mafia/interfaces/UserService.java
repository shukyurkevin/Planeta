package com.kevin.planeta.mafia.interfaces;

import com.kevin.planeta.mafia.models.User;
import java.util.List;
import java.util.Optional;

public interface UserService {

  public List<User> findAll();

  public Optional<User> findById(Long id);

  public User save(User model);

  public User update(Long id, User model);

  public void deleteById(Long id);

  public boolean existsById(Long id);

}
