package com.example.demo.advertisement;

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

import java.util.List;

@RestController
@RequestMapping

public class AdvertisementController {
    @Autowired
    private AdvertisementService adService;


    @GetMapping("ads")
    @ApiOperation(value = "Get all advertisements", notes = "Returns a paginated list of all advertisements")
    public List<Advertisement> getAllAdvertisements(@RequestParam(defaultValue = "0") int page,
                                                    @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Advertisement> advertisementPage = adService.getAllAdvertisements(pageable);
        return advertisementPage.getContent();
    }
       @GetMapping("/{restaurantId}/ads")
       @ApiOperation(value = "Get advertisements by restaurant ID", notes = "Returns a paginated list of advertisements by restaurant ID")
    public ResponseEntity<Page<Advertisement>> getAdvertisementsByVenueId(@PathVariable Long restaurantId,
                                                                          @RequestParam(defaultValue = "0") int page,
                                                                          @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Advertisement> advertisements = adService.getAdvertisementsByVenueId(restaurantId, pageable);
        return new ResponseEntity<>(advertisements, HttpStatus.OK);
    }


}
