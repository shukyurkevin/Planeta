package com.kevin.planeta.mafia.service;

import com.kevin.planeta.mafia.entity.UserEntity;
import com.kevin.planeta.mafia.interfaces.MapperInterface;
import com.kevin.planeta.mafia.interfaces.UserServiceInterface;
import com.kevin.planeta.mafia.models.User;
import com.kevin.planeta.mafia.repositories.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserServiceInterface {

  private final UserRepository userRepository;
  private final MapperInterface<User, UserEntity> userMapper;

  @Autowired
  public UserServiceImp(UserRepository userRepository,
                            MapperInterface<User, UserEntity> userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
  }


  @Override
  public List<User> findAll() {
    return userRepository
            .findAll()
            .stream()
        .map(userMapper::mapToModel)
        .toList();
  }

  @Override
  public Optional<User> findById(Long id) {
    return userRepository.findById(id)
        .map(userMapper::mapToModel);
  }

  @Override
  public User save(User model) {
    userRepository.save(userMapper.mapToEntity(model));
    return model;
  }

  @Override
  public User update(Long id, User model) {

    if (!userRepository.existsById(id)){
        throw new RuntimeException("User not found");
    }

    UserEntity userEntity = userMapper.mapToEntity(model);
    userEntity.setId(id);

    userRepository.save(userEntity);
    // Update the model with the new ID
    return model;
  }

  @Override
  public void deleteById(Long id) {

    if (!userRepository.existsById(id)) {
      throw new RuntimeException("User not found");
    }
    userRepository.deleteById(id);
  }

  @Override
  public boolean existsById(Long id) {
    return userRepository.existsById(id);
  }
}
