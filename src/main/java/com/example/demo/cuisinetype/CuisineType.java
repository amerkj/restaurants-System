package com.example.demo.cuisinetype;

import com.example.demo.restaurant.Restaurant;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cuisine_types")

public class CuisineType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "image", nullable = false)
    private String image;
    @OneToMany(fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Restaurant> restaurants;

    public CuisineType() {}

    public CuisineType(String name, String image) {
        this.name = name;
        this.image = image;
    }

    // getters and setters

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

}
