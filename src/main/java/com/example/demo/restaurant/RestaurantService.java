package com.example.demo.restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service

public class RestaurantService {
    private final RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Cacheable(value = "restaurants")
    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    public Restaurant getRestaurantById(Long id) {
        return restaurantRepository.findById(id).orElse(null);
    }

    public Restaurant createRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    public boolean deleteRestaurantById(Long id) {
        if (restaurantRepository.existsById(id)) {
            restaurantRepository.deleteById(id);
            return true;
        }
        return false;
    }


    public List<Restaurant> getFeaturedRestaurants() {
        return restaurantRepository.findFeaturedRestaurants();
    }
    public List<Restaurant> searchRestaurants(String query) {
        // perform a database query to search for restaurants matching the query string
        List<Restaurant> matchingRestaurants = restaurantRepository.findByNameContainingIgnoreCase(query);

        return matchingRestaurants;
    }

    public List<Restaurant> filterRestaurants(RestaurantFilterDto filterDto) {
        return restaurantRepository.findByFilters(filterDto.getName(), filterDto.getLocation(), filterDto.getCuisineTypeId());
    }


}
