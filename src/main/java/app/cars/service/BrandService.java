package app.cars.service;

import app.cars.entity.Brand;
import app.cars.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {

    @Autowired
    private BrandRepository brandRepository;

    // Save a Brand
    public String save(Brand brand) {
        this.brandRepository.save(brand);
        return brand.getName() + " successfully saved!";
    }

    // Update a Brand by ID
    public String update(Brand brand, Long id){
        brand.setId(id);
        brandRepository.save(brand);
        return (brand.getName() + " successfully updated!");
    }

    // Delete a Brand by ID
    public String delete(Long id) {
        this.brandRepository.deleteById(id);
        return "Brand with id("+id+") successfully deleted!";
    }

    // List all Brands
    public List<Brand> listAll() {
        return this.brandRepository.findAll();
    }

    // Find all Brands by ID
    public Brand findById(Long id) {
        return this.brandRepository.findById(id).get();
    }
}
