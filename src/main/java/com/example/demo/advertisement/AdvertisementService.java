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

    @CacheEvict(value = "advertisement", allEntries = true)

    public Advertisement saveAdvertisement(Advertisement ad) {
        return adRepo.save(ad);
    }
    
    @Cacheable(value = "advertisement")

    public Page<Advertisement> getAllAdvertisements(Pageable pageable) {
        return adRepo.findAll(pageable);
    }

    public Advertisement getAdvertisementById(Long id) {
        return adRepo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Advertisement not found with id " + id));
    }

    public Page<Advertisement> getAdvertisementsByVenueId(Long restaurantId, Pageable pageable) {
        return adRepo.findByRestaurantId(restaurantId, pageable);
    }
}
