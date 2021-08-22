package com.lemoncode21.springbootonetomanymanytoone.service;

import com.lemoncode21.springbootonetomanymanytoone.model.BrandCars;

import java.util.List;

public interface BrandCarsService {

    List<BrandCars> retrieveAll();

    BrandCars retrieveDetail(Long id);

    void create(BrandCars brandCars);

    void delete(Long id);

    void update(Long id,BrandCars brandCars);
}
