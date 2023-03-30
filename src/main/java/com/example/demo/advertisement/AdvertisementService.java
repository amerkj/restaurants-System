package com.example.demo.advertisement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
public class AdvertisementService {
    @Autowired
    private AdvertisementRepository adRepo;

//    public Advertisement saveAdvertisement(Advertisement ad) {
//        return adRepo.save(ad);
//    }
//
//    public List<Advertisement> getAllAdvertisements() {
//        return adRepo.findAll();
//    }
//
//    public Advertisement getAdvertisementById(Long id) {
//        return adRepo.findById(id)
//                .orElseThrow(() -> new NoSuchElementException("Advertisement not found with id " + id));
//    }

    public List<Advertisement> getAdvertisementsByVenueId(Long restaurant_id) {
        return adRepo.findByRestaurantId(restaurant_id);
    }
}
