package com.kevin.planeta.mafia.mappers;

import com.kevin.planeta.mafia.entity.UserEntity;
import com.kevin.planeta.mafia.models.User;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("UserMapper Tests")
public class UserMapperTests {

  private UserMapper userMapper;

  @BeforeAll
  public void setUserMapper(){
    userMapper = new UserMapper();
  }

  private User createTestUser() {
    return new User(8L, "testUser", "passbord", "qiwen@gmail.com", "PLAYER",
        "https://example.com/avatar.png", "localhost", "localhost2134", true);
  }

  private UserEntity createTestUserEntity() {
    return new UserEntity(4L, "testUserEntity", "password", "kevin@gmail.com", "Game_MASTER",
        "https://example22.com/avatar.png", "google", "google3454", false);
  }


  private void assertUserEquals(User user, UserEntity entity) {
    assert entity.getId().equals(user.getId());
    assert entity.getUsername().equals(user.getUsername());
    assert entity.getPassword().equals(user.getPassword());
    assert entity.getEmail().equals(user.getEmail());
    assert entity.getRole().equals(user.getRole());
    assert entity.getProfilePictureUrl().equals(user.getProfilePictureUrl());
    assert entity.getProvider().equals(user.getProvider());
    assert entity.getProviderId().equals(user.getProviderId());
    assert entity.getEnabled() == user.getEnabled();
  }

  @Test
  @DisplayName("Map User to UserEntity")
  public void mapToUserEntity() {

    User user = createTestUser();
    UserEntity mappedUserEntity = userMapper.mapToEntity(user);
    assertUserEquals(user, mappedUserEntity);

    }
  @Test
  @DisplayName("Map UserEntity to User")
  public void mapToUser() {

    UserEntity userEntity = createTestUserEntity();
    User mappedUser = userMapper.mapToModel(userEntity);
    assertUserEquals(mappedUser, userEntity);

  }

  @Test
  @DisplayName("Map User list to UnserEntity list")
  public void mapToUserEntityList() {
    User user = createTestUser();
    List<User> users = List.of(user, user, user, user);
    List<UserEntity> mappedUsers = userMapper.mapToEntityList(users);
    assert mappedUsers.size() == users.size();
    for (int i = 0; i < users.size(); i++) {
      assertUserEquals(users.get(i), mappedUsers.get(i));
    }
  }



  @Test
  @DisplayName("Map UserEntity list to User list")
  public void mapToUserList() {
    UserEntity userEntity = createTestUserEntity();
    List<UserEntity> userEntities = List.of(userEntity, userEntity, userEntity);
    List<User> mappedUsers = userMapper.mapToModelList(userEntities);
    assert mappedUsers.size() == userEntities.size();
    for (int i = 0; i < userEntities.size(); i++) {
      assertUserEquals(mappedUsers.get(i), userEntities.get(i));
    }
  }

}