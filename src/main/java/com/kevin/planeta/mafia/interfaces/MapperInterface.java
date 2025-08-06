package com.kevin.planeta.mafia.interfaces;

import java.util.List;

public interface MapperInterface<M, E> {

  public E mapToEntity(M model);

  public M mapToModel(E entity);

  public List<E> mapToEntityList(List<M> modelList);

  public List<M> mapToModelList(List<E> entityList);

}
