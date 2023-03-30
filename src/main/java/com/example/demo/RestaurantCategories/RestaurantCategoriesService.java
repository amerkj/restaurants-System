package com.example.demo.RestaurantCategories;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantCategoriesService {

    public List<RestaurantCategories> getRestaurantCategories() {
        return List.of(new RestaurantCategories(
                1l,
                "shameat",
                "aaaa"
        ));
    }
}
