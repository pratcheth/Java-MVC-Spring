package org.softuni.initialproject.data.models;

import com.fasterxml.jackson.databind.deser.BuilderBasedDeserializer;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.id.GUIDGenerator;
import org.hibernate.loader.plan.spi.QuerySpaceUidNotRegisteredException;

import javax.annotation.processing.Generated;
import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {
    private String id;
    private String model;
    private String brand;
    private Integer year;
    private String engine;

    public Car() {
    }


    @Id
    @GeneratedValue(generator = "uuid-string")
    @GenericGenerator(name = "uuid-string",
    strategy = "org.hibernate.id.UUIDGenerator")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "model", nullable = false)
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Column(name = "brand", nullable = false)
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Column(name = "year", nullable = false)
    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }
}
