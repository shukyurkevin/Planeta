package com.kevin.planeta.mafia.mappers;

import com.kevin.planeta.mafia.entity.UserEntity;
import com.kevin.planeta.mafia.interfaces.MapperInterface;
import com.kevin.planeta.mafia.models.User;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements MapperInterface<User, UserEntity> {
  @Override
  public UserEntity mapToEntity(User user) {

    return new UserEntity(user.getId(),
        user.getUsername(),
        user.getPassword(),
        user.getEmail(),
        user.getRole(),
        user.getProfilePictureUrl(),
        user.getProvider(),
        user.getProviderId(),
        user.getEnabled());

  }

  @Override
  public User mapToModel(UserEntity user) {
    return new User(user.getId(),
        user.getUsername(),
        user.getPassword(),
        user.getEmail(),
        user.getRole(),
        user.getProfilePictureUrl(),
        user.getProvider(),
        user.getProviderId(),
        user.getEnabled());
  }

  @Override
  public List<UserEntity> mapToEntityList(List<User> users) {
    return users.stream()
        .map(this::mapToEntity)
        .toList();
  }

  @Override
  public List<User> mapToModelList(List<UserEntity> userEntities) {
    return userEntities.stream()
        .map(this::mapToModel)
        .toList();
  }
}
