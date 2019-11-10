package com.asal.DTO;

public class CarStatus extends BasicItem {
    String engineStatus;
    String transmissionSystemHealth;
    String fuel;

    public CarStatus() {
    }

    public CarStatus(String engineStatus, String transmissionSystemHealth, String fuel) {
        this.engineStatus = engineStatus;
        this.transmissionSystemHealth = transmissionSystemHealth;
        this.fuel = fuel;
    }

    public String getEngineStatus() {
        return engineStatus;
    }

    public void setEngineStatus(String engineStatus) {
        this.engineStatus = engineStatus;
    }

    public String getTransmissionSystemHealth() {
        return transmissionSystemHealth;
    }

    public void setTransmissionSystemHealth(String transmissionSystemHealth) {
        this.transmissionSystemHealth = transmissionSystemHealth;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }
}
