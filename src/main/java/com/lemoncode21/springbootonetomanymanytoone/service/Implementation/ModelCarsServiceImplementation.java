package com.lemoncode21.springbootonetomanymanytoone.service.Implementation;

import com.lemoncode21.springbootonetomanymanytoone.model.ModelCars;
import com.lemoncode21.springbootonetomanymanytoone.repository.ModelCarsRepository;
import com.lemoncode21.springbootonetomanymanytoone.service.ModelCarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModelCarsServiceImplementation implements ModelCarsService {

    @Autowired
    private ModelCarsRepository modelCarsRepository;

    @Override
    public List<ModelCars> retrieveAll() {
        return this.modelCarsRepository.findAll();
    }

    @Override
    public ModelCars retrieveDetail(Long id) {
        return this.modelCarsRepository.getById(id);
    }

    @Override
    public void create(ModelCars modelCars) {
        this.modelCarsRepository.save(modelCars);
    }

    @Override
    public void delete(Long id) {
        this.modelCarsRepository.deleteById(id);
    }

    @Override
    public void update(Long id, ModelCars modelCars) {
        //Find brand cars by id
        ModelCars _modelCars = this.modelCarsRepository.getById(id);
        //Update brand cars
        _modelCars.setName(modelCars.getName());
        _modelCars.setPrice(modelCars.getPrice());
        _modelCars.setProductionYear(modelCars.getProductionYear());
        _modelCars.setBrandCars(modelCars.getBrandCars());
    }
}
