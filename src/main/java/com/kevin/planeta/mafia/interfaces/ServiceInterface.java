package com.kevin.planeta.mafia.interfaces;

import java.util.List;
import java.util.Optional;

public interface ServiceInterface<T, ID> {

  List<T> findAll();

  Optional<T> findById(ID id);

  T save(T entity);

  T update(ID id, T entity);

  void deleteById(ID id);

  boolean existsById(ID id);

}
