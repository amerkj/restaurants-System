package com.example.demo.restaurant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import org.springframework.data.jpa.repository.Query;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long>{

    Page<Restaurant> findByCuisineTypeId(Long id, Pageable pageable);

    List<Restaurant> findByNameContainingIgnoreCase(String query);

    @Query("SELECT r FROM Restaurant r WHERE " +
            "(:name IS NULL OR LOWER(r.name) LIKE CONCAT('%', LOWER(:name), '%')) AND " +
            "(:location IS NULL OR LOWER(r.address) LIKE CONCAT('%', LOWER(:location), '%')) AND " +
            "(:cuisineTypeId IS NULL OR r.cuisineType.id = :cuisineTypeId)")
    List<Restaurant> findByFilters(@Param("name") String name, @Param("location") String location,
                                   @Param("cuisineTypeId") Long cuisineTypeId);
}
