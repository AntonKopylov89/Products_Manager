package ru.netology.domain;

public class Smartphone extends Product {
    private String manufacturer;

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Smartphone(int id, String name, String manufacturer, int price) {
        super(id, name, price);
        this.manufacturer = manufacturer;
    }
}
