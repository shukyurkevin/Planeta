package com.kevin.planeta.mafia.interfaces;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public interface ServiceInterface<T, ID> {

  List<T> findAll();

  Optional<T> findById(ID id);

  T save(T model);

  T update(ID id, T model);

  void deleteById(ID id);

  boolean existsById(ID id);

}
