package com.lemoncode21.springbootonetomanymanytoone.service;

import com.lemoncode21.springbootonetomanymanytoone.model.BrandCars;
import com.lemoncode21.springbootonetomanymanytoone.model.ModelCars;

import java.util.List;

public interface ModelCarsService {

    List<ModelCars> retrieveAll();

    ModelCars retrieveDetail(Long id);

    void create(ModelCars modelCars);

    void delete(Long id);

    void update(Long id,ModelCars modelCars);
}
