package com.kevin.planeta.mafia.integration;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest
@Testcontainers(disabledWithoutDocker = true)
@ActiveProfiles("test")
public abstract class BaseIntegrationTest {

  @Container
  protected static final PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>
      ("postgres:17")
      .withDatabaseName("qiwen-tests")
      .withUsername("kevin")
      .withPassword("test");

  static {
    postgres.start();
    System.setProperty("spring.datasource.url", postgres.getJdbcUrl());
    System.setProperty("spring.datasource.username", postgres.getUsername());
    System.setProperty("spring.datasource.password", postgres.getPassword());
  }

}

