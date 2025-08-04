package com.kevin.planeta.Mafia.service;

import com.kevin.planeta.Mafia.entity.Event;
import com.kevin.planeta.Mafia.interfaces.Service;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Component;


@Component
public class EventServiceImp implements Service<Event, Long> {
  @Override
  public List<Event> findAll() {
    return List.of();
  }

  @Override
  public Optional<Event> findById(Long aLong) {
    return Optional.empty();
  }

  @Override
  public Event save(Event entity) {
    return null;
  }

  @Override
  public Event update(Long aLong, Event entity) {
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
