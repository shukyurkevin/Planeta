package com.kevin.planeta.mafia.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class UserEntity {
    // This class represents a user entity in the Mafia game application.
  @Id
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "username", nullable = false)
  private String username;

  @Column(name = "password", nullable = false)
  private String password;

  @Column(name = "email", nullable = false)
  private String email;

  @Column(name = "role", nullable = false)
  private String role;

  @Column(name = "profile_picture_url", nullable = false)
  private String profilePictureUrl ="https://www.quickanddirtytips.com/wp-content/uploads/2022/08/shutterstock_699567733-scaled.jpg";

  @Column(name = "provider")
  private String provider;

  @Column(name = "provider_id")
  private String providerId;

  @Column(name = "enabled", nullable = false)
  private Boolean enabled = true;

}
