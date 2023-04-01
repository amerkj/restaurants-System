package com.example.demo.advertisement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
public class AdvertisementService {
    @Autowired
    private AdvertisementRepository adRepo;


    @Cacheable(value = "advertisement")

    public Page<Advertisement> getAllAdvertisements(Pageable pageable) {
        return adRepo.findAll(pageable);
    }

    public Page<Advertisement> getAdvertisementsByVenueId(Long restaurantId, Pageable pageable) {
        return adRepo.findByRestaurantId(restaurantId, pageable);
    }
}
