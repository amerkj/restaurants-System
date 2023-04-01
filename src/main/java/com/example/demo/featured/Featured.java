package com.example.demo.featured;

import com.example.demo.restaurant.Restaurant;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "featured")
public class Featured {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "image", nullable = false)
    private String image;

    // Many-to-many relationship with restaurants
    @ManyToMany
    @JoinTable(
            name = "restaurant_featured",
            joinColumns = { @JoinColumn(name = "featured_id") },
            inverseJoinColumns = { @JoinColumn(name = "restaurant_id") }
    )
    private Set<Restaurant> restaurants = new HashSet<>();

    // Getters and setters
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

    public Set<Restaurant> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(Set<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }
}
