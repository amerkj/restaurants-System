package com.example.demo.restaurant;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import javax.validation.ValidationException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("restaurants")
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;



    @GetMapping("/cuisine-type")
    @ApiOperation(value = "Get all restaurants", notes = "Returns a list of all restaurants")
    public ResponseEntity<Page<Restaurant>> getAllRestaurants(@RequestParam(defaultValue = "0") int page,
                                                              @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Restaurant> restaurants = restaurantService.getAllRestaurants(pageable);
        return new ResponseEntity<>(restaurants, HttpStatus.OK);
    }

    @GetMapping("/cuisine-type/{id}")
    @ApiOperation(value = "Get restaurants by cuisine type ID", notes = "Returns a list of restaurants by cuisine type ID")
    public ResponseEntity<Page<Restaurant>> getRestaurantsByCuisineTypeId(
            @PathVariable Long id,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Restaurant> restaurants = restaurantService.getRestaurantsByCuisineTypeId(id, pageable);
        return new ResponseEntity<>(restaurants, HttpStatus.OK);
    }

    @PostMapping("/add")
    @ApiOperation(value = "Create restaurant", notes = "IT SHOULD BE LOGGED IN AND ,Creates a new restaurant")
    public ResponseEntity<?> createRestaurant(@Valid @RequestBody Restaurant restaurant, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String error = bindingResult.getFieldErrors().stream()
                    .map(fe -> fe.getField() + " " + fe.getDefaultMessage())
                    .collect(Collectors.joining(", "));
            return ResponseEntity.badRequest().body(error);
        }
        Restaurant createdRestaurant = restaurantService.createRestaurant(restaurant);
        return new ResponseEntity<>(createdRestaurant, HttpStatus.CREATED);
    }

    @PostMapping("/search")
    @ApiOperation(value = "Search restaurants", notes = "IT SHOULD BE LOGGED IN AND Returns a list of restaurants matching the provided query")
    public ResponseEntity<List<Restaurant>> searchRestaurants(@RequestBody Map<String, String> requestBody) {
        String query = requestBody.get("query");
        List<Restaurant> restaurants = restaurantService.searchRestaurants(query);
        return new ResponseEntity<>(restaurants, HttpStatus.OK);
    }
    @PostMapping("/filter")
    @ApiOperation(value = "Filter restaurants", notes = "IT SHOULD BE LOGGED IN AND Returns a list of restaurants filtered by the provided criteria  ")
    public ResponseEntity<List<Restaurant>> filterRestaurants(@RequestBody RestaurantFilterDto filter) {
        List<Restaurant> restaurants = restaurantService.filterRestaurants(filter);
        return ResponseEntity.ok(restaurants);
    }



}

