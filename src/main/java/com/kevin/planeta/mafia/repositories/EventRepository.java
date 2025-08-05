package com.kevin.planeta.mafia.repositories;

import com.kevin.planeta.mafia.models.Event;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Event, Long> {

    // Additional query methods can be defined here if needed
    // For example:
    // List<Event> findByName(String name);
    // Optional<Event> findById(Long id);

}
