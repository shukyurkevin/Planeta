package com.kevin.planeta.mafia.service;

import com.kevin.planeta.mafia.entity.EventEntity;
import com.kevin.planeta.mafia.interfaces.EventServiceInterface;
import com.kevin.planeta.mafia.interfaces.MapperInterface;
import com.kevin.planeta.mafia.models.Event;
import com.kevin.planeta.mafia.repositories.EventRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;
import org.springframework.stereotype.Service;


@Service
public class EventServiceImp implements EventServiceInterface {

  private final EventRepository eventRepository;
  private final MapperInterface<Event, EventEntity> eventMapper;

  public EventServiceImp(EventRepository eventRepository,
                         MapperInterface<Event, EventEntity> eventMapper) {
    this.eventRepository = eventRepository;
    this.eventMapper = eventMapper;
  }


  @Override
  public List<Event> findAll() {
    List<Event> events = StreamSupport.stream(eventRepository
        .findAll()
        .spliterator(), false)
        .map(eventMapper::mapToModel)
        .toList();
    return events;
  }

  @Override
  public Optional<Event> findById(Long id) {
    return eventRepository.findById(id)
        .map(eventMapper::mapToModel);
  }

  @Override
  public Event save(Event model) {
    eventRepository.save(eventMapper.mapToEntity(model));
    return model;
  }

  @Override
  public Event update(Long id, Event model) {

    if (!eventRepository.existsById(id)){
      throw new RuntimeException("event not found");
    }
    EventEntity eventEntity = eventMapper.mapToEntity(model);
    eventEntity.setId(id);

    eventRepository.save(eventEntity);

    return model;
  }

  @Override
  public void deleteById(Long id) {
    if (!eventRepository.existsById(id)) {
      throw new RuntimeException("event not found");
    }
    eventRepository.deleteById(id);
  }

  @Override
  public boolean existsById(Long id) {
    return eventRepository.existsById(id);
  }

}
