package com.kevin.planeta.mafia.unit.mappers;

import com.kevin.planeta.mafia.entity.EventEntity;
import com.kevin.planeta.mafia.mappers.EventMapper;
import com.kevin.planeta.mafia.models.Event;
import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("EventMapper Tests")
public class EventMapperTests {

  private EventMapper eventMapper;

  @BeforeAll
    public void setEventMapper() {
        eventMapper = new EventMapper();
    }
  private Event createTestEvent() {
    return new Event(2L, "Test Event",LocalDate.of(2023, 10, 1), 120L);
  }

  private EventEntity createTestEventEntity() {
    return new EventEntity(3L, "Test EventEntity",LocalDate.of(2025, 12, 5), 145L);
  }

  private void assertEvent(Event event, EventEntity entity) {
    assert event.getId().equals(entity.getId());
    assert event.getEventName().equals(entity.getEventName());
    assert event.getDate().equals(entity.getDate());
    assert event.getDuration().equals(entity.getDuration());

  }

  @Test
  @DisplayName("Map Event to EventEntity")
  public void MapToEventEntity() {
    Event event = createTestEvent();
    EventEntity mappedEventEntity = eventMapper.mapToEntity(event);
    assertEvent(event, mappedEventEntity);
  }
  @Test
  @DisplayName("Map EventEntity to Event")
  public void MapToEvent() {
    EventEntity eventEntity = createTestEventEntity();
    Event mappedEvent = eventMapper.mapToModel(eventEntity);
    assertEvent(mappedEvent, eventEntity);
  }
  @Test
  @DisplayName("Map Event List to EventEntity List")
  public void MapToEventEntityList() {
    List<Event> events = List.of(createTestEvent(), createTestEvent(), createTestEvent());
    List<EventEntity> mappedEventEntities = eventMapper.mapToEntityList(events);
    assert mappedEventEntities.size() == events.size();
    for (int i = 0; i < events.size(); i++) {
      assertEvent(events.get(i), mappedEventEntities.get(i));
    }
  }

  @Test
  @DisplayName("Map EventEntity List to Event List")
  public void MapToEventList() {
    List<EventEntity> eventEntities = List.of(createTestEventEntity(), createTestEventEntity(), createTestEventEntity());
    List<Event> mappedEvents = eventMapper.mapToModelList(eventEntities);
    assert mappedEvents.size() == eventEntities.size();
    for (int i = 0; i < eventEntities.size(); i++) {
      assertEvent(mappedEvents.get(i), eventEntities.get(i));
    }
  }
}
