package com.lemoncode21.springbootonetomanymanytoone.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;


@Table(name = BrandCars.TABLE_NAME)
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BrandCars {

    public static final String TABLE_NAME = "brand_cars";
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String CREATED_AT = "created_at";


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = BrandCars.ID)
    private Long id;
    @Column(name = BrandCars.NAME)
    private String name;
    @Column(name = BrandCars.CREATED_AT)
    private Date createAt = new Date();
    @OneToMany(mappedBy = ModelCars.TABLE_NAME, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<ModelCars> modelCars;

}
