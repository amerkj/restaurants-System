package com.example.demo.cuisinetype;
import java.util.List;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
    @ApiOperation(value = "Get all cuisine types", notes = "Returns a paginated list of all cuisine types")
    public ResponseEntity<Page<CuisineType>> getAllCuisineTypes(@RequestParam(defaultValue = "0") int page,
                                                                @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<CuisineType> cuisineTypes = cuisineTypeService.getAllCuisineTypes(pageable);
        return new ResponseEntity<>(cuisineTypes, HttpStatus.OK);
    }





}