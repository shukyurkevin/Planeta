package com.kevin.planeta.mafia.entity;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
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

  @Column("Duration")
  // Duration in minutes, can be null if not specified
  private Long duration;


}
