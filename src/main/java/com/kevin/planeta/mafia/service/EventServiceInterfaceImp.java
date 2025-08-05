package com.kevin.planeta.mafia.service;

import com.kevin.planeta.mafia.entity.EventEntity;
import com.kevin.planeta.mafia.interfaces.EventServiceInterface;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Component;


@Component
public class EventServiceInterfaceImp implements EventServiceInterface {
  @Override
  public List<EventEntity> findAll() {
    return List.of();
  }

  @Override
  public Optional<EventEntity> findById(Long aLong) {
    return Optional.empty();
  }

  @Override
  public EventEntity save(EventEntity entity) {
    return null;
  }

  @Override
  public EventEntity update(Long aLong, EventEntity entity) {
    return null;
  }

  @Override
  public void deleteById(Long aLong) {

  }

  @Override
  public boolean existsById(Long aLong) {
    return false;
  }
}
