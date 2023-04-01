package com.example.demo.featured;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FeaturedService {

    @Autowired
    private FeaturedRepository featuredRepository;

    public List<FeaturedDTO> getAllFeaturedWithCount() {
        return featuredRepository.getAllFeaturedWithCount().stream()
                .map(featuredObject -> {
                    FeaturedDTO featuredDTO = new FeaturedDTO();
                    featuredDTO.setId((Long) featuredObject[0]);
                    featuredDTO.setName((String) featuredObject[1]);
                    featuredDTO.setImage((String) featuredObject[2]);
                    featuredDTO.setRestaurantCount((Long) featuredObject[3]);
                    return featuredDTO;
                })
                .collect(Collectors.toList());
    }
}
