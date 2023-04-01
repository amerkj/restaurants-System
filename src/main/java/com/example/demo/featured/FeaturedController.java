package com.example.demo.featured;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/featured")
public class FeaturedController {

    @Autowired
    private FeaturedService featuredService;

    @GetMapping
    @ApiOperation(value = "Get all featured items with count", notes = "Returns a list of all featured items with their count")
    public ResponseEntity<List<FeaturedDTO>> getAllFeaturedWithCount() {
        List<FeaturedDTO> featuredDTOList = featuredService.getAllFeaturedWithCount();
        return ResponseEntity.ok(featuredDTOList);
    }
}


