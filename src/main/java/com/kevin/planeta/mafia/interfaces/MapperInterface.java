package com.kevin.planeta.mafia.interfaces;

import java.util.List;

public interface MapperInterface<M, E> {

  E mapToEntity(M model);

  M mapToModel(E entity);

  List<E> mapToEntityList(List<M> modelList);

  List<M> mapToModelList(List<E> entityList);

}
