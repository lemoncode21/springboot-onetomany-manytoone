package com.lemoncode21.springbootonetomanymanytoone.service.Implementation;

import com.lemoncode21.springbootonetomanymanytoone.model.BrandCars;
import com.lemoncode21.springbootonetomanymanytoone.repository.BrandCarsRepository;
import com.lemoncode21.springbootonetomanymanytoone.service.BrandCarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandCarsServiceImplementation implements BrandCarsService {

    @Autowired
    private BrandCarsRepository brandCarsRepository;

    @Override
    public List<BrandCars> retrieveAll() {
        return this.brandCarsRepository.findAll();
    }

    @Override
    public BrandCars retrieveDetail(Long id) {
        return this.brandCarsRepository.getById(id);
    }

    @Override
    public void create(BrandCars brandCars) {
        this.brandCarsRepository.save(brandCars);
    }

    @Override
    public void delete(Long id) {
        this.brandCarsRepository.deleteById(id);
    }

    @Override
    public void update(Long id, BrandCars brandCars) {
        //Find brand cars by id
        BrandCars _brandCars = this.brandCarsRepository.getById(id);
        //Update brand cars
        _brandCars.setName(brandCars.getName());
        this.brandCarsRepository.save(_brandCars);
    }
}
