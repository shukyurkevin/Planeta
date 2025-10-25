package com.kevin.planeta.mafia.mappers;

import com.kevin.planeta.mafia.entity.EventEntity;
import com.kevin.planeta.mafia.interfaces.MapperInterface;
import com.kevin.planeta.mafia.models.Event;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class EventMapper implements MapperInterface<Event, EventEntity> {

  @Override
  public EventEntity mapToEntity(Event eventModel) {

    return new EventEntity(
            eventModel.getId(),
            eventModel.getEventName(),
            eventModel.getDate(),
            eventModel.getDuration()
        );
  }

  @Override
  public Event mapToModel(EventEntity eventEntity) {

    return new Event(
            eventEntity.getId(),
            eventEntity.getEventName(),
            eventEntity.getDate(),
            eventEntity.getDuration()
        );
    }

  @Override
  public List<EventEntity> mapToEntityList(List<Event> events) {
    return events.stream()
        .map(this::mapToEntity)
        .toList();
  }

  @Override
  public List<Event> mapToModelList(List<EventEntity> eventEntities) {
    return eventEntities.stream()
        .map(this::mapToModel)
        .toList();
  }
}
