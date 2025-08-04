package com.kevin.planeta.Mafia.entity;

import org.springframework.data.relational.core.mapping.Table;

@Table("Events")
public class EventEntity {

  private String name;

  private String date;


}
