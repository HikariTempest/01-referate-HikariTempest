package at.htl.vehicle;

import java.util.Objects;

public class Vehicle {
    private String licensePlate;
    private String model;
    private String color;
    private int year;

    public Vehicle(String licensePlate, String model, String color, int year) {
        this.setLicensePlate(licensePlate);
        this.setModel(model);
        this.setColor(color);
        this.setYear(year);
    }

    public Vehicle() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return year == vehicle.year && Objects.equals(licensePlate, vehicle.licensePlate) && Objects.equals(model, vehicle.model) && Objects.equals(color, vehicle.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(licensePlate, model, color, year);
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "licensePlate='" + licensePlate + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", year=" + year +
                '}';
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
