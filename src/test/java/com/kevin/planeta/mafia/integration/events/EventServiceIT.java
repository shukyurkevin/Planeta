package com.kevin.planeta.mafia.integration.events;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.kevin.planeta.mafia.integration.BaseIntegrationTest;
import com.kevin.planeta.mafia.interfaces.EventService;
import com.kevin.planeta.mafia.models.Event;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@DisplayName("IT tests for EventService")
class EventServiceIT extends BaseIntegrationTest {

  @Autowired
  private EventService eventService;

  @Test
  @DisplayName("Getting all events from db")
  void findAll(){
    List<Event> events = eventService.findAll();
    assertEquals(8,events.size());
  }


}
