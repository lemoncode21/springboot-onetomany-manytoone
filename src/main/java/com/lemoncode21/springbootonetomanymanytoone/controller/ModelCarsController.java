package com.lemoncode21.springbootonetomanymanytoone.controller;


import com.lemoncode21.springbootonetomanymanytoone.model.BrandCars;
import com.lemoncode21.springbootonetomanymanytoone.model.ModelCars;
import com.lemoncode21.springbootonetomanymanytoone.response.ResponseHandler;
import com.lemoncode21.springbootonetomanymanytoone.service.ModelCarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/modelCars")
public class ModelCarsController {

    @Autowired
    ModelCarsService modelCarsService;

    // Create
    @PostMapping("/create")
    public ResponseHandler create(@RequestBody ModelCars modelCars){
        try{
            this.modelCarsService.create(modelCars);
            return new ResponseHandler(HttpStatus.OK.toString(),"Success saved data!");
        }catch (Exception e){
            return new ResponseHandler(HttpStatus.MULTI_STATUS.toString(),e.getMessage());
        }
    }

    //	Retrieve All
    @GetMapping
    public ResponseHandler retrieveAll(){
        try{
            List<ModelCars> modelCarsList = this.modelCarsService.retrieveAll();
            return  new ResponseHandler(HttpStatus.OK.toString(), "Success retrieve all data!",modelCarsList);
        }catch (Exception e){
            return new ResponseHandler(HttpStatus.MULTI_STATUS.toString(),e.getMessage());
        }
    }

    //	Retrieve Detail
    @GetMapping(value = "/{id}")
    public ResponseHandler getDetail(@PathVariable("id")Long id){
        try{
            ModelCars modelCars = this.modelCarsService.retrieveDetail(id);
            return  new ResponseHandler(HttpStatus.OK.toString(),"Success retrieve detail data!", modelCars);
        }catch (Exception e){
            return  new ResponseHandler(HttpStatus.MULTI_STATUS.toString(),e.getMessage());
        }
    }

    //	Update
    @PutMapping(value = "/{id}")
    public ResponseHandler update(@PathVariable("id")Long id,@RequestBody ModelCars modelCars){
        try{
            this.modelCarsService.update(id,modelCars);
            return new ResponseHandler(HttpStatus.OK.toString(),"Success update data");
        }catch (Exception e){
            return new ResponseHandler(HttpStatus.MULTI_STATUS.toString(),e.getMessage());
        }
    }

    //	Delete
    @DeleteMapping("/{id}")
    public ResponseHandler delete(@PathVariable("id")Long id){
        try{
            this.modelCarsService.delete(id);
            return new ResponseHandler(HttpStatus.OK.toString(), "Success deleted data!");
        }catch (Exception e){
            return new ResponseHandler(HttpStatus.MULTI_STATUS.toString(),e.getMessage());
        }
    }
}
