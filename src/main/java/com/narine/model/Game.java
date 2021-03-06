package com.narine.model;

public class Game {
    private String name;
    private double price;
    private int quantity;
    private Company company;
    public enum Company {
        UBISOFT, BUNGIE, BETHESDA
    }

    public Game(String name, double price, int quantity, Company company) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
