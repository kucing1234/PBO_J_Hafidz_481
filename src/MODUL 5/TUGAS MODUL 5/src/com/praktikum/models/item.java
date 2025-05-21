package com.praktikum.models;

public class item {
    private final String itemName;
    private final String description;
    private final String location;
    private String status;

    public item(String itemName, String description, String location) {
        this.itemName = itemName;
        this.description = description;
        this.location = location;
        this.status = "Reported";
    }

    // Getter dan Setter
    public String getItemName() {
        return itemName;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
