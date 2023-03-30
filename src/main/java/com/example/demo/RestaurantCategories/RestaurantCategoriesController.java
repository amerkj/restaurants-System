package com.example.demo.RestaurantCategories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/restaurantcategories")
public class RestaurantCategoriesController {
    private final RestaurantCategoriesService restaurantCategoriesService ;

    //debendencs injection
    @Autowired
    public RestaurantCategoriesController(RestaurantCategoriesService restaurantCategoriesService) {
        this.restaurantCategoriesService = restaurantCategoriesService;
    }

    @GetMapping
    public List<RestaurantCategories> hello() {
        return restaurantCategoriesService.getRestaurantCategories();

    }
}
