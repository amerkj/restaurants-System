package com.example.demo.advertisement;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdvertisementRepository extends JpaRepository<Advertisement, Long> {
    List<Advertisement> findByRestaurantId(Long restaurantId);
    Page<Advertisement> findByRestaurantId(Long restaurantId, Pageable pageable);
}