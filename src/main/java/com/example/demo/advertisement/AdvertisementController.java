package com.example.demo.advertisement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping

public class AdvertisementController {
    @Autowired
    private AdvertisementService adService;


//    @GetMapping
//    public List<Advertisement> getAllAdvertisements() {
//        return adService.getAllAdvertisements();
//    }
//
//    @GetMapping("/{id}")
//    public Advertisement getAdvertisementById(@PathVariable Long id) {
//        return adService.getAdvertisementById(id);
//    }
//
//    @PostMapping("/")
//    public Advertisement createAdvertisement(@RequestBody Advertisement ad) {
//        return adService.saveAdvertisement(ad);
//    }
    @GetMapping("/{restaurantId}/ads")
    public ResponseEntity<List<Advertisement>> getAdvertisementsByVenueId(@PathVariable Long restaurantId) {
        List<Advertisement> advertisements = adService.getAdvertisementsByVenueId(restaurantId);
        return new ResponseEntity<>(advertisements, HttpStatus.OK);
    }


}
