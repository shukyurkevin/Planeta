package com.kevin.planeta.mafia.models;


import java.time.LocalDate;

public class Event {
  private Long id;

  private String eventName;

  private LocalDate date;



  public Event(Long id, String eventName, LocalDate date) {
        this.id = id;
        this.eventName = eventName;
        this.date = date;
    }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getEventName() {
    return eventName;
  }

  public void setEventName(String eventName) {
    this.eventName = eventName;
  }

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }
}
