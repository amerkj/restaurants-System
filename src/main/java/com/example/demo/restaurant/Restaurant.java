package com.example.demo.restaurant;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.example.demo.advertisement.Advertisement;
import com.example.demo.cuisinetype.CuisineType;
import com.example.demo.featured.Featured;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "restaurants")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is mandatory")
    @Column(nullable = false)
    private String name;

    @NotBlank(message = "Address is mandatory")
    @Column(nullable = false)
    private String address;

    @NotBlank(message = "Phone is mandatory")
    @Column(nullable = false)
    private String phone;

    @NotNull(message = "Latitude is mandatory")
    @Column(nullable = false)
    private Float latitude;

    @NotNull(message = "Longitude is mandatory")
    @Column(nullable = false)
    private Float longitude;

    @NotBlank(message = "Image is mandatory")
    @Column(nullable = false)
    private String image;


    @OneToMany(fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Advertisement> advertisements;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cuisine_type_id")
    @JsonBackReference
    private CuisineType cuisineType;

    @ManyToMany(mappedBy = "restaurants")
    private Set<Featured> features = new HashSet<>();

    public Restaurant() {
    }

    public Restaurant(String name, String address, String phone, Float latitude, Float longitude, String image, CuisineType cuisineType) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.latitude = latitude;
        this.longitude = longitude;
        this.image = image;
        this.cuisineType=cuisineType;
    }

    // getter and setter methods

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public CuisineType getCuisineType() {
        return cuisineType;
    }

    public void setCuisineType(CuisineType cuisineType) {
        this.cuisineType = cuisineType;
    }
}

