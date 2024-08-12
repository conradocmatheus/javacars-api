package app.cars.service;

import app.cars.entity.Accessory;
import app.cars.repository.AccessoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccessoryService {

    @Autowired
    public AccessoryRepository accessoryRepository;

    // Save an Accessory
    public String save(Accessory accessory) {
        this.accessoryRepository.save(accessory);
        return "Accessory: " + accessory.getName() + " successfully saved!";
    }

    // Update an Accessory by ID
    public String update(Accessory accessory, Long id) {
        accessory.setId(id);
        accessoryRepository.save(accessory);
        return "Accessory: " + accessory.getName() + " successfully updated!";
    }

    // Delete an Accessory by ID
    public String delete(Long id) {
        this.accessoryRepository.deleteById(id);
        return "Accessory with id(" + id + ") successfully deleted!";
    }

    // List all Accessories
    public List<Accessory> listAll() {
        return this.accessoryRepository.findAll();
    }

    // Find an Accessory by ID
    public Accessory findById(Long id) {
        return this.accessoryRepository.findById(id).orElse(null);
    }
}
