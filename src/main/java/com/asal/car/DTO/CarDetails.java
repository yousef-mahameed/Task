package com.asal.car.DTO;

public class CarDetails {

    private int carId;
    private String plateLicense;
    private int manufacturerId;
    private int seatCount;
    private boolean convertible;
    private String engineType;
    private double rating;

    public CarDetails() {
    }

    public CarDetails(int carId, String plateLicense, int manufacturerId, int seatCount, boolean convertible, String engineType, double rating) {
        this.carId = carId;
        this.plateLicense = plateLicense;
        this.manufacturerId = manufacturerId;
        this.seatCount = seatCount;
        this.convertible = convertible;
        this.engineType = engineType;
        this.rating = rating;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
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
}
