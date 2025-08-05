package com.kevin.planeta.mafia.entity;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("Events")
public class EventEntity {
// This class represents an event entity in the Mafia game application.
  @NotNull
  @Column("Id")
  private Long id;

  @Column("Name")
  private String eventName;

  @Column("Date")
  // Using Local from Spring CGLIB for date representation
  private LocalDate date;

  public EventEntity(Long id, String eventName, LocalDate date) {
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

  public void setName(String eventName) {
    this.eventName = eventName;
  }

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }
}
