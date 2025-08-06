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
@Entity
public class EventEntity {
// This class represents an event entity in the Mafia game application.

  @Id
  private Long id;

  @Column
  private String eventName;

  @Column
  private LocalDate date;
  // Duration in minutes, can be null if not specified
  @Column
  private Long duration;


}
