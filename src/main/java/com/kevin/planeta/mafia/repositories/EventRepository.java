package com.kevin.planeta.mafia.repositories;

import com.kevin.planeta.mafia.entity.EventEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface EventRepository extends CrudRepository<EventEntity, Long> {


    // Additional query methods can be defined here if needed
    // For example:
    // List<Event> findByName(String name);
    // Optional<Event> findById(Long id);

}
