package com.kevin.planeta.mafia.unit.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.kevin.planeta.mafia.entity.UserEntity;
import com.kevin.planeta.mafia.exeption.UserNotFoundException;
import com.kevin.planeta.mafia.mappers.UserMapper;
import com.kevin.planeta.mafia.models.User;
import com.kevin.planeta.mafia.repositories.UserRepository;
import com.kevin.planeta.mafia.service.UserServiceImpl;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@DisplayName("Tests for UserService")
@ExtendWith(MockitoExtension.class)
public class UserServiceTests {

  @InjectMocks
  private UserServiceImpl userService;

  @Mock
  private UserMapper userMapper;

  @Mock
  private UserRepository userRepository;

  private User createUserModel(Long id){
    return new User(id,"Qiwen","qiwen228","Qiwen@gmail.com"
        ,"TestSubject","someUrl.com","God","human642134",true);
  }

  private UserEntity createUserEntity(Long id){
    return new UserEntity(id,"Qiwen","qiwen228","Qiwen@gmail.com"
        ,"TestSubject","someUrl.com","God","human642134",true);
  }
  private void verifyUserEquality(UserEntity entity, User model){
    assertEquals(entity.getId(), model.getId());
    assertEquals(entity.getUsername(), model.getUsername());
    assertEquals(entity.getPassword(), model.getPassword());
    assertEquals(entity.getEmail(), model.getEmail());
    assertEquals(entity.getRole(), model.getRole());
    assertEquals(entity.getProfilePictureUrl(), model.getProfilePictureUrl());
    assertEquals(entity.getProvider(), model.getProvider());
    assertEquals(entity.getProviderId(), model.getProviderId());
    assertEquals(entity.getEnabled(), model.getEnabled());
  }


  @Test
  @DisplayName("Test findAllUsers")
  public void findAllUsers(){

    UserEntity entity = createUserEntity(4L);
    User model = createUserModel(4L);

    when(userMapper.mapToModel(entity)).thenReturn(model);
    when(userRepository.findAll()).thenReturn(List.of(entity));

    List<User> list = userService.findAll();

    verifyUserEquality(entity, list.getFirst());

    verify(userMapper).mapToModel(entity);
    verify(userRepository).findAll();
  }

  @Test
  @DisplayName("Test findAllUsers When there is no Users")
  public void findAllUsersEmpty(){

    when(userRepository.findAll()).thenReturn(List.of());

    List<User> result = userService.findAll();

    assertEquals(0, result.size());
    verify(userRepository).findAll();
  }
  @Test
  @DisplayName("Test findUserById")
  public void findUserById(){

    UserEntity entity = createUserEntity(3L);
    User model = createUserModel(3L);

    when(userRepository.findById(3L)).thenReturn(Optional.of(entity));
    when(userMapper.mapToModel(entity)).thenReturn(model);

    Optional<User> result = userService.findById(3L);

    assertTrue(result.isPresent());
    verifyUserEquality(entity, result.get());

    verify(userRepository).findById(3L);
    verify(userMapper).mapToModel(entity);
  }
  @Test
  @DisplayName("Test findUserById not found")
  public void findUserByIdNotFound(){
    when(userRepository.findById(113L)).thenReturn(Optional.empty());

    Optional<User> result = userService.findById(113L);

    assertTrue(result.isEmpty());
    verify(userRepository).findById(113L);
  }

  @Test
  @DisplayName("Test User save")
  public void saveUser(){

    UserEntity entity = createUserEntity(5L);
    User model = createUserModel(5L);

    when(userMapper.mapToModel(entity)).thenReturn(model);
    when(userRepository.save(entity)).thenReturn(entity);

    User result = userService.save(model);

    verifyUserEquality(entity, result);

    verify(userMapper).mapToModel(entity);
    verify(userRepository).save(entity);
  }

  @Test
  @DisplayName("Test User update")
  public void userUpdate(){

    UserEntity entity = createUserEntity(1L);
    User model = createUserModel(1L);

    when(userRepository.existsById(1L)).thenReturn(true);
    when(userRepository.save(entity)).thenReturn(entity);
    when(userMapper.mapToEntity(model)).thenReturn(entity);

    User UpdatedUser = userService.update(1L, model);

    verifyUserEquality(entity, UpdatedUser);

    verify(userRepository).existsById(1L);
    verify(userRepository).save(entity);
    verify(userMapper).mapToEntity(model);
  }

  @Test
  @DisplayName("Test User update if no User is found")
  public void updateUserNotFound(){

    User model = createUserModel(3L);

    when(userRepository.existsById(5L)).thenReturn(false);

    assertThrows(UserNotFoundException.class,() -> userService.update(5L, model));
    verify(userRepository).existsById(5L);
  }

  @Test
  @DisplayName("Test User deleteById")
  public void deleteUser(){

    when(userRepository.existsById(2L)).thenReturn(true);

    userService.deleteById(2L);

    verify(userRepository).existsById(2L);
    verify(userRepository).deleteById(2L);
  }

  @Test
  @DisplayName("Test User deleteById not found")
  public void deleteUserNotFound(){

    when(userRepository.existsById(2L)).thenReturn(false);

    assertThrows(UserNotFoundException.class,() -> userService.deleteById(2L));
    verify(userRepository).existsById(2L);
  }

  @Test
  @DisplayName("Test User existById")
  public void existById(){

    when(userRepository.existsById(4L)).thenReturn(true);

    assertTrue(userService.existsById(4L));
    verify(userRepository).existsById(4L);
  }

  @Test
  @DisplayName("Test User existById return false")
  public void notExistById(){

    when(userRepository.existsById(4L)).thenReturn(false);

    assertFalse(userService.existsById(4L));
    verify(userRepository).existsById(4L);
  }
}
