package com.lemoncode21.springbootonetomanymanytoone.repository;

import com.lemoncode21.springbootonetomanymanytoone.model.BrandCars;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandCarsRepository extends JpaRepository<BrandCars,Long> {
}
