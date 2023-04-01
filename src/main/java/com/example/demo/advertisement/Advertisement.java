package com.example.demo.advertisement;

import com.example.demo.cuisinetype.CuisineType;
import com.example.demo.restaurant.Restaurant;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "advertisements")
public class Advertisement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "image", nullable = false)
    private String image;

//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "restaurant_id", nullable = false)
//    private Restaurant restaurant;
//
@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "restaurant_id")
@JsonBackReference
private Restaurant restaurant;



    public Advertisement() {}

    public Advertisement(String title, String description, String image, Restaurant restaurant) {
        this.title = title;
        this.description = description;
        this.image = image;
        this.restaurant = restaurant;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

}
