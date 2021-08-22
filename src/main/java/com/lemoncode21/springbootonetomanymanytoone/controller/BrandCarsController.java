package com.lemoncode21.springbootonetomanymanytoone.controller;


import com.lemoncode21.springbootonetomanymanytoone.model.BrandCars;
import com.lemoncode21.springbootonetomanymanytoone.response.ResponseHandler;
import com.lemoncode21.springbootonetomanymanytoone.service.BrandCarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brandCars")
public class BrandCarsController {

    @Autowired
    BrandCarsService brandCarsService;

    // Create
    @PostMapping("/create")
    public ResponseHandler create(@RequestBody BrandCars brandCars){
        try{
            this.brandCarsService.create(brandCars);
            return new ResponseHandler(HttpStatus.OK.toString(),"Success saved data!");
        }catch (Exception e){
            return new ResponseHandler(HttpStatus.MULTI_STATUS.toString(),e.getMessage());
        }
    }

    //	Retrieve All
    @GetMapping
    public ResponseHandler retrieveAll(){
        try{
            List<BrandCars> brandCarsList = this.brandCarsService.retrieveAll();
            return  new ResponseHandler(HttpStatus.OK.toString(), "Success retrieve all data!",brandCarsList);
        }catch (Exception e){
            return new ResponseHandler(HttpStatus.MULTI_STATUS.toString(),e.getMessage());
        }
    }

    //	Retrieve Detail
    @GetMapping(value = "/{id}")
    public ResponseHandler getDetail(@PathVariable("id")Long id){
        try{
            BrandCars brandCars = this.brandCarsService.retrieveDetail(id);
            return  new ResponseHandler(HttpStatus.OK.toString(),"Success retrieve detail data!", brandCars);
        }catch (Exception e){
            return  new ResponseHandler(HttpStatus.MULTI_STATUS.toString(),e.getMessage());
        }
    }

    //	Update
    @PutMapping(value = "/{id}")
    public ResponseHandler update(@PathVariable("id")Long id,@RequestBody BrandCars brandCars){
        try{
            this.brandCarsService.update(id,brandCars);
            return new ResponseHandler(HttpStatus.OK.toString(),"Success update data");
        }catch (Exception e){
            return new ResponseHandler(HttpStatus.MULTI_STATUS.toString(),e.getMessage());
        }
    }

    //	Delete
    @DeleteMapping("/{id}")
    public ResponseHandler delete(@PathVariable("id")Long id){
        try{
            this.brandCarsService.delete(id);
            return new ResponseHandler(HttpStatus.OK.toString(), "Success deleted data!");
        }catch (Exception e){
            return new ResponseHandler(HttpStatus.MULTI_STATUS.toString(),e.getMessage());
        }
    }

}
