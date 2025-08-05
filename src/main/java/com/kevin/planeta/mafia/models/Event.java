package com.kevin.planeta.mafia.models;


import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Event {
  private Long id;

  private String eventName;

  private LocalDate date;

  private Long duration;

}
