package com.example.demo.restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public Page<Restaurant> getAllRestaurants(Pageable pageable) {
        return restaurantRepository.findAll(pageable);
    }

    @Cacheable(value = "restaurantsbycosin")
    public Page<Restaurant> getRestaurantsByCuisineTypeId(Long id, Pageable pageable) {
        return restaurantRepository.findByCuisineTypeId(id, pageable);
    }

    @CacheEvict(value = {"restaurants","restaurantsbycosin"}, allEntries = true)
    public Restaurant createRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
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
