package com.lemoncode21.springbootonetomanymanytoone.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


@Table(name = ModelCars.TABLE_NAME)
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ModelCars {

    public static final String TABLE_NAME = "model_cars";
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String PRODUCTION_YEAR = "production_year";
    public static final String PRICE = "price";
    public static final String CREATED_AT = "created_at";
    public static final String BRAND_CARS_ID = "brand_cars_id";


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name=ModelCars.ID)
    private Long id;

    @Column(name=ModelCars.NAME)
    private String name;

    @Column(name=ModelCars.PRODUCTION_YEAR)
    private String productionYear;

    @Column(name=ModelCars.PRICE)
    private BigDecimal price;

    @Column(name=ModelCars.CREATED_AT)
    private Date createAt = new Date();

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = ModelCars.BRAND_CARS_ID,referencedColumnName = BrandCars.ID, nullable = false)
    private BrandCars brandCars;

}
