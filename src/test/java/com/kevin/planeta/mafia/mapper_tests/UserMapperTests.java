package com.kevin.planeta.mafia.mapper_tests;

import com.kevin.planeta.mafia.entity.UserEntity;
import com.kevin.planeta.mafia.mappers.UserMapper;
import com.kevin.planeta.mafia.models.User;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@RequiredArgsConstructor
public class UserMapperTests {

  private UserMapper userMapper;

  @BeforeEach
  public void setUserMapper(){
    userMapper = new UserMapper();
  }

  @Test
  public void mapToUserEntity() {

        User user = new User(4L,
            "testUser",
            "password",
            "qiwen@gmail.com",
            "PLAYER",
            "https://example.com/avatar.png",
            "localhost",
            "localhost2134",
            true);
        UserEntity mappedUser = userMapper.mapToEntity(user);
        assert mappedUser.getId().equals(user.getId());
        assert mappedUser.getUsername().equals(user.getUsername());
        assert mappedUser.getPassword().equals(user.getPassword());
        assert mappedUser.getEmail().equals(user.getEmail());
        assert mappedUser.getRole().equals(user.getRole());
        assert mappedUser.getProfilePictureUrl().equals(user.getProfilePictureUrl());
        assert mappedUser.getProvider().equals(user.getProvider());
        assert mappedUser.getProviderId().equals(user.getProviderId());
        assert mappedUser.getEnabled() == user.getEnabled();
    }

}