package com.example.demo.restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import org.springframework.data.jpa.repository.Query;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long>{
    @Query("SELECT r FROM Restaurant r WHERE r.featured = true")
    List<Restaurant> findFeaturedRestaurants();

}
