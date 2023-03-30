package com.example.demo.cuisinetype;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/restaurants/cuisine")
public class CuisineTypeController {

    @Autowired
    private CuisineTypeService cuisineTypeService;

    @GetMapping
    public List<CuisineType> getAllCuisineTypes() {
        return cuisineTypeService.getAllCuisineTypes();
    }

    @GetMapping("/{id}")
    public CuisineType getCuisineTypeById(@PathVariable int id) {
        return cuisineTypeService.getCuisineTypeById(id);
    }

    @PostMapping
    public void saveCuisineType(@RequestBody CuisineType cuisineType) {
        cuisineTypeService.saveCuisineType(cuisineType);
    }

    @DeleteMapping("/{id}")
    public void deleteCuisineTypeById(@PathVariable int id) {
        cuisineTypeService.deleteCuisineTypeById(id);
    }

}