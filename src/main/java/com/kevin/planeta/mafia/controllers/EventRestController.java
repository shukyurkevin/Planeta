package com.kevin.planeta.mafia.controllers;

import com.kevin.planeta.mafia.interfaces.ServiceInterface;
import com.kevin.planeta.mafia.models.Event;
import com.kevin.planeta.mafia.service.EventServiceImp;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping("/api/events")
public class EventRestController {

  private final ServiceInterface<Event, Long> eventService;
    // Constructor injection for the service interface
  public EventRestController(ServiceInterface<Event, Long> eventService) {
    this.eventService = eventService;
  }

  @RequestMapping("/allEvents")
  public List<Event> getAllEvents() {
    return eventService.findAll();
  }

  @RequestMapping("/eventById")
  public Event getEventById(Long id){
    return eventService.findById(id)
        .orElseThrow(() -> new RuntimeException("Event not found with id: " + id));
  }

  @RequestMapping("/newEvent")
  public Event createEvent(Event event) {
    return eventService.save(event);
  }

  @RequestMapping("/updateEvent")
  public Event updateEvent(Long id, Event event) {
    return eventService.update(id, event);
  }

  @RequestMapping("/deleteEvent")
  public void deleteEvent(Long id) {
    eventService.deleteById(id);
  }
  @RequestMapping("/eventExists")
  public boolean eventExists(Long id) {
        return eventService.existsById(id);
  }
}
