package com.kevin.planeta.mafia.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "events")
public class EventEntity {
// This class represents an event entity in the Mafia game application.

  @Id
  @Column(name = "id")
  private Long id;

  @Column(name = "name", nullable = false)
  private String eventName;

  @Column(name = "event_date", nullable = false)
  private LocalDate date;

    // Duration in minutes
  @Column(name = "duration", nullable = false)
  private Long duration;


}
