package com.kevin.planeta.mafia.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class User {

  private Long id;

  private String username;

  private String password;

  private String email;

  private String role;

  private String profilePictureUrl;

  private String provider;

  private String providerId;

  private Boolean enabled;
}
