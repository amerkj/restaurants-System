package com.example.demo.featured;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeaturedRepository extends JpaRepository<Featured, Long> {

    @Query("SELECT f.id, f.name, f.image, COUNT(r.id) " +
            "FROM Featured f " +
            "LEFT JOIN f.restaurants r " +
            "GROUP BY f.id")
    List<Object[]> getAllFeaturedWithCount();

}
