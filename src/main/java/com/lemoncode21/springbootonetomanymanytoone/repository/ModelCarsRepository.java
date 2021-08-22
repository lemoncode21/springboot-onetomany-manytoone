package com.lemoncode21.springbootonetomanymanytoone.repository;

import com.lemoncode21.springbootonetomanymanytoone.model.ModelCars;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelCarsRepository extends JpaRepository<ModelCars,Long> {
}
