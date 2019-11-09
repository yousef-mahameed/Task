package com.asal.car.model;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "cars")
public class Car{

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "license_plate", unique = true)
    @NotNull
    private String plateLicense;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manufacturer_id")
    @NotNull
    private Manufacturer manufacturer;

    @Column(name = "seat_count")
    private Integer seatCount;

    @Column(name = "convertible")
    private Boolean convertible;

    @Column(name = "engine_type")
    private String engineType;

    @Column(name = "rating")
    private Double rating;

    public Car() {
    }

    public Car(String plateLicense, Manufacturer manufacturer, Integer seatCount, Boolean convertible, String engineType, Double rating) {
        this.plateLicense = plateLicense;
        this.manufacturer = manufacturer;
        this.seatCount = seatCount;
        this.convertible = convertible;
        this.engineType = engineType;
        this.rating = rating;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlateLicense() {
        return plateLicense;
    }

    public void setPlateLicense(String plateLicense) {
        this.plateLicense = plateLicense;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Integer getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(Integer seatCount) {
        this.seatCount = seatCount;
    }

    public Boolean getConvertible() {
        return convertible;
    }

    public void setConvertible(Boolean convertible) {
        this.convertible = convertible;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }
}
