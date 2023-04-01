package com.example.demo.cuisinetype;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/restaurants/cuisine")
public class CuisineTypeController {

    @Autowired
    private CuisineTypeService cuisineTypeService;

    @GetMapping
    public ResponseEntity<Page<CuisineType>> getAllCuisineTypes(@RequestParam(defaultValue = "0") int page,
                                                                @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<CuisineType> cuisineTypes = cuisineTypeService.getAllCuisineTypes(pageable);
        return new ResponseEntity<>(cuisineTypes, HttpStatus.OK);
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