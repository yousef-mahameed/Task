package com.asal.car.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;

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
    private Boolean isConvertible;

    @Column(name = "engine_type")
    private String engineType;

    @Column(name = "rating")
    private Double rating;

    @Column(name = "selected")
    private Boolean isSelected;

    @Column(name = "created_on")
    private ZonedDateTime createdOn;

    public Car() {
    }

    public Car(String plateLicense, Manufacturer manufacturer, Integer seatCount, Boolean isConvertible,
               String engineType, Double rating, Boolean isSelected, ZonedDateTime createdOn) {
        this.plateLicense = plateLicense;
        this.manufacturer = manufacturer;
        this.seatCount = seatCount;
        this.isConvertible = isConvertible;
        this.engineType = engineType;
        this.rating = rating;
        this.isSelected = isSelected;
        this.createdOn = createdOn;
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

    public Boolean getIsConvertible() {
        return isConvertible;
    }

    public void setIsConvertible(Boolean isConvertible) {
        this.isConvertible = isConvertible;
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

    public Boolean getIsSelected() {
        return isSelected;
    }

    public void setIsSelected(Boolean isSelected) {
        this.isSelected = isSelected;
    }

    public ZonedDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(ZonedDateTime createdOn) {
        this.createdOn = createdOn;
    }
}
