package com.kevin.planeta.mafia.interfaces;

import java.util.List;
import org.springframework.stereotype.Component;

@Component
public interface MapperInterface<Model, ENTITY> {

  public ENTITY mapToEntity(Model model);

  public Model mapToModel(ENTITY entity);

  public List<ENTITY> mapToEntityList(List<Model> modelList);

  public List<Model> mapToModelList(List<ENTITY> entityList);

}
