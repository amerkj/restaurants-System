package com.example.demo.advertisement;

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


    @GetMapping
    public List<Advertisement> getAllAdvertisements() {
        return adService.getAllAdvertisements();
    }

    @GetMapping("/{id}")
    public Advertisement getAdvertisementById(@PathVariable Long id) {
        return adService.getAdvertisementById(id);
    }

    @PostMapping("/")
    public Advertisement createAdvertisement(@RequestBody Advertisement ad) {
        return adService.saveAdvertisement(ad);
    }
    @GetMapping("/{restaurantId}/ads")
    public ResponseEntity<Page<Advertisement>> getAdvertisementsByVenueId(@PathVariable Long restaurantId,
                                                                          @RequestParam(defaultValue = "0") int page,
                                                                          @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Advertisement> advertisements = adService.getAdvertisementsByVenueId(restaurantId, pageable);
        return new ResponseEntity<>(advertisements, HttpStatus.OK);
    }


}
