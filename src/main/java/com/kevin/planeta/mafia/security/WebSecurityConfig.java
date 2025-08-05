package com.kevin.planeta.mafia.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {

  SecurityFilterChain webConfig(HttpSecurity http) throws Exception {;
  http.cors(Customizer.withDefaults())
      .csrf(AbstractHttpConfigurer::disable)
      .authorizeHttpRequests(auth -> auth
          .requestMatchers("/api/v1/events/**").permitAll()
          .anyRequest().authenticated())
      .httpBasic(Customizer.withDefaults());

  return http.build();
  }
}
