package com.example.demo.restaurant;

public class RestaurantFilterDto {
    private String name;
    private String location;
    private Long cuisineTypeId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Long getCuisineTypeId() {
        return cuisineTypeId;
    }

    public void setCuisineTypeId(Long cuisineTypeId) {
        this.cuisineTypeId = cuisineTypeId;
    }
}