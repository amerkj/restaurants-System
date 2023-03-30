package com.example.demo.cuisinetype;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;




@Service
public class CuisineTypeService {

    @Autowired
    private CuisineTypeRepository cuisineTypeRepository;

    public List<CuisineType> getAllCuisineTypes() {
        return cuisineTypeRepository.findAll();
    }

    public CuisineType getCuisineTypeById(int id) {
        Optional<CuisineType> optionalCuisineType = cuisineTypeRepository.findById(id);
        return optionalCuisineType.orElse(null);
    }

    public void saveCuisineType(CuisineType cuisineType) {
        cuisineTypeRepository.save(cuisineType);
    }

    public void deleteCuisineTypeById(int id) {
        cuisineTypeRepository.deleteById(id);
    }

}
