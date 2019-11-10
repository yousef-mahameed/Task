package com.asal.DTO;

import java.time.ZonedDateTime;

public class CarDetails extends BasicItem{

    private String plateLicense;
    private int manufacturerId;
    private int seatCount;
    private boolean convertible;
    private String engineType;
    private double rating;
    private boolean isSelected;
    private ZonedDateTime createdOn;

    public CarDetails() {
    }

    public CarDetails(int carId, String plateLicense, int manufacturerId, int seatCount,
                      boolean convertible, String engineType, double rating,
                      boolean isSelected, ZonedDateTime createdOn) {
        this.setId(carId);
        this.plateLicense = plateLicense;
        this.manufacturerId = manufacturerId;
        this.seatCount = seatCount;
        this.convertible = convertible;
        this.engineType = engineType;
        this.rating = rating;
        this.isSelected = isSelected;
        this.createdOn = createdOn;
    }

    public String getPlateLicense() {
        return plateLicense;
    }

    public void setPlateLicense(String plateLicense) {
        this.plateLicense = plateLicense;
    }

    public int getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(int manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public int getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }

    public boolean isConvertible() {
        return convertible;
    }

    public void setConvertible(boolean convertible) {
        this.convertible = convertible;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public ZonedDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(ZonedDateTime createdOn) {
        this.createdOn = createdOn;
    }
}
