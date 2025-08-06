package com.kevin.planeta.mafia.repositories;

import com.kevin.planeta.mafia.entity.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<EventEntity, Long> {
    // Additional query methods can be defined here if needed


}
