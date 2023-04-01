package com.example.demo.restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("restaurants")
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;


    // GET all restaurants
    @GetMapping
    public ResponseEntity<Page<Restaurant>> getAllRestaurants(@RequestParam(defaultValue = "0") int page,
                                                              @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Restaurant> restaurants = restaurantService.getAllRestaurants(pageable);
        return new ResponseEntity<>(restaurants, HttpStatus.OK);
    }

    // GET restaurant by ID
    @GetMapping("/{id}")
    public ResponseEntity<Restaurant> getRestaurantById(@PathVariable Long id) {
        Restaurant restaurant = restaurantService.getRestaurantById(id);
        if (restaurant == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }

    // POST new restaurant
    @PostMapping("/add")
    public ResponseEntity<Restaurant> createRestaurant(@RequestBody Restaurant restaurant) {
        Restaurant createdRestaurant = restaurantService.createRestaurant(restaurant);
        return new ResponseEntity<>(createdRestaurant, HttpStatus.CREATED);
    }

    // DELETE restaurant by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRestaurantById(@PathVariable Long id) {
        boolean deleted = restaurantService.deleteRestaurantById(id);
        if (!deleted) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // GET restaurants where featured = true
    @GetMapping("/featured-categories")
    public ResponseEntity<Page<Restaurant>> getFeaturedRestaurants(@RequestParam(defaultValue = "0") int page,
                                                                   @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Restaurant> featuredRestaurants = restaurantService.getFeaturedRestaurants(pageable);
        return new ResponseEntity<>(featuredRestaurants, HttpStatus.OK);
    }
    @PostMapping("/search")
    public ResponseEntity<List<Restaurant>> searchRestaurants(@RequestBody Map<String, String> requestBody) {
        String query = requestBody.get("query");
        List<Restaurant> restaurants = restaurantService.searchRestaurants(query);
        return new ResponseEntity<>(restaurants, HttpStatus.OK);
    }
    @PostMapping("/filter")
    public ResponseEntity<List<Restaurant>> filterRestaurants(@RequestBody RestaurantFilterDto filter) {
        List<Restaurant> restaurants = restaurantService.filterRestaurants(filter);
        return ResponseEntity.ok(restaurants);
    }

}

