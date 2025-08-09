package com.kevin.planeta.mafia.unit.services;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.kevin.planeta.mafia.entity.EventEntity;
import com.kevin.planeta.mafia.exeption.EventNotFoundException;
import com.kevin.planeta.mafia.mappers.EventMapper;
import com.kevin.planeta.mafia.models.Event;
import com.kevin.planeta.mafia.repositories.EventRepository;
import com.kevin.planeta.mafia.service.EventServiceImpl;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@DisplayName("Unit tests for EventService")
@ExtendWith(MockitoExtension.class)
public class EventServiceTests {

  @Mock
  private EventRepository eventRepository;

  @Mock
  private EventMapper eventMapper;

  @InjectMocks
  private EventServiceImpl eventService;

  private EventEntity createTestEventEntity(Long id) {
    return new EventEntity(id, "Test Event "+ id, OffsetDateTime.now().toLocalDate(), 180L);
  }

  private Event createTestEvent(Long id) {
    return new Event(id, "Test Event "+ id, OffsetDateTime.now().toLocalDate(), 180L);
  }

  private void verifyEventEquality(EventEntity entity, Event model){
    assertEquals(entity.getId(), model.getId());
    assertEquals(entity.getEventName(), model.getEventName());
    assertEquals(entity.getDate(), model.getDate());
    assertEquals(entity.getDuration(), model.getDuration());
  }

  @Test
  @DisplayName("Test findAllEvents")
  public void findAllEvents() {
    EventEntity eventEntity = createTestEventEntity(4L);
    Event event = createTestEvent(4L);
    when(eventRepository.findAll()).thenReturn(List.of(eventEntity));
    when(eventMapper.mapToModel(eventEntity)).thenReturn(event);

    List<Event> events = eventService.findAll();

    verifyEventEquality(eventEntity,events.getFirst());
    verify(eventRepository).findAll();
    verify(eventMapper).mapToModel(eventEntity);

  }

  @Test
  @DisplayName("Test getEventById")
  public void findEventById() {

    EventEntity eventEntity = createTestEventEntity(3L);
    Event event = createTestEvent(3L);

    when(eventRepository.findById(3L)).thenReturn(Optional.of(eventEntity));
    when(eventMapper.mapToModel(eventEntity)).thenReturn(event);

    Optional<Event> foundEvent = eventService.findById(3L);

    assertTrue(foundEvent.isPresent());
    verifyEventEquality(eventEntity,foundEvent.get());

    verify(eventRepository).findById(3L);
    verify(eventMapper).mapToModel(eventEntity);
  }
  @Test
  @DisplayName("Test getEventById if not found")
  public void findEventByIdNotFound() {

    when(eventRepository.findById(99L)).thenReturn(Optional.empty());

    Optional<Event> foundEvent = eventService.findById(99L);

    assertTrue(foundEvent.isEmpty());
    verify(eventRepository).findById(99L);
  }

  @Test
  @DisplayName("Test Event save")
  public void saveEvent() {

    Event event = createTestEvent(2L);
    EventEntity eventEntity = createTestEventEntity(2L);

    when(eventMapper.mapToEntity(event)).thenReturn(eventEntity);
    when(eventRepository.save(eventEntity)).thenReturn(eventEntity);

    Event savedEvent = eventService.save(event);

    verifyEventEquality(eventEntity,savedEvent);

    verify(eventMapper).mapToEntity(event);
    verify(eventRepository).save(eventEntity);
  }

  @Test
  @DisplayName("Test Event update")
  public void updateEvent(){

    Event event = createTestEvent(6L);
    EventEntity eventEntity = createTestEventEntity(6L);

    when(eventMapper.mapToEntity(event)).thenReturn(eventEntity);
    when(eventRepository.existsById(6L)).thenReturn(true);
    when(eventRepository.save(eventEntity)).thenReturn(eventEntity);

    Event updatedEvent = eventService.update(6L, event);

    verifyEventEquality(eventEntity, updatedEvent);

    verify(eventMapper).mapToEntity(event);
    verify(eventRepository).existsById(6L);
    verify(eventRepository).save(eventEntity);
  }

  @Test
  @DisplayName("Test Event update if no event is found")
  public void updateEventNotFound(){

    Event event = createTestEvent(3L);

    when(eventRepository.existsById(3L)).thenReturn(false);

    assertThrows(EventNotFoundException.class, () -> eventService.update(3L, event));
    verify(eventRepository).existsById(3L);
  }

  @Test
  @DisplayName("Test Event deleteById")
  public void deleteById(){

    when(eventRepository.existsById(3L)).thenReturn(true);

    eventService.deleteById(3L);

    verify(eventRepository).existsById(3L);
    verify(eventRepository).deleteById(3L);
  }
  @Test
  @DisplayName("Test Event deleteById if no event is found")
  public void deleteByIdNotFound(){

    when(eventRepository.existsById(2L)).thenReturn(false);

    assertThrows(EventNotFoundException.class,() -> eventService.deleteById(2L));
    verify(eventRepository).existsById(2L);
  }
  @Test
  @DisplayName("Test Event existById")
  public void existById(){

    when(eventRepository.existsById(7L)).thenReturn(true);

    assertTrue(eventService.existsById(7L));
    verify(eventRepository).existsById(7L);
  }
  @Test
  @DisplayName("Test Event existById returns false")
  public void existByIdReturnsFalse() {

    when(eventRepository.existsById(8L)).thenReturn(false);

    assertFalse(eventService.existsById(8L));
    verify(eventRepository).existsById(8L);
  }

}
