package com.kevin.planeta.mafia.interfaces;

import com.kevin.planeta.mafia.models.Event;
import java.util.List;
import java.util.Optional;

public interface EventService {

  List<Event> findAll();

  Optional<Event> findById(Long id);

  Event save(Event model);

  Event update(Long id, Event model);

  void deleteById(Long id);

  boolean existsById(Long id);
}
