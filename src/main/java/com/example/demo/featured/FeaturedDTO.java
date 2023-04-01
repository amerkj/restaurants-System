package com.example.demo.featured;
public class FeaturedDTO {
    private Long id;
    private String name;
    private String image;
    private Long restaurantCount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getRestaurantCount() {
        return restaurantCount;
    }

    public void setRestaurantCount(Long restaurantCount) {
        this.restaurantCount = restaurantCount;
    }
}
