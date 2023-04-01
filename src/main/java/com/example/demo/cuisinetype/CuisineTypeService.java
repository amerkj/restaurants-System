package com.example.demo.cuisinetype;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;




@Service
public class CuisineTypeService {

    @Autowired
    private CuisineTypeRepository cuisineTypeRepository;
    @Cacheable(value = "cuisine")

    public Page<CuisineType> getAllCuisineTypes(Pageable pageable) {
        return cuisineTypeRepository.findAll(pageable);
    }

}
