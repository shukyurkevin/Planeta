package com.kevin.planeta.mafia.controllers;

import com.kevin.planeta.mafia.interfaces.ServiceInterface;
import com.kevin.planeta.mafia.models.Event;
import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/events")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EventRestController {

  private final ServiceInterface<Event, Long> eventService;

  @GetMapping("/allEvents")
  public List<Event> getAllEvents() {
    return eventService.findAll();
  }

  @GetMapping("/eventById/{id}")
  public Event getEventById(@PathVariable(name = "id") Long id){
    return eventService.findById(id)
        .orElseThrow(() -> new RuntimeException("Event not found with id: " + id));
  }

  @PostMapping("/newEvent")
  public Event createEvent(@RequestBody Event event) {
    return eventService.save(event);
  }

  @PostMapping("/updateEvent/{id}")
  public Event updateEvent(@PathVariable(name = "id") Long id,@RequestBody Event event)
  {
    return eventService.update(id, event);
  }

  @PostMapping("/deleteEvent/{id}")
  public void deleteEvent(@PathVariable(name = "id") Long id) {
    eventService.deleteById(id);
  }

  @GetMapping("/eventExists/{id}")
  public boolean eventExists(@PathVariable(name = "id") Long id) {
        return eventService.existsById(id);
  }
}
