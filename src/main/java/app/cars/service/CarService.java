package app.cars.service;

import app.cars.entity.Car;
import app.cars.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    // Save a Car
    public String save(Car car){
        this.carRepository.save(car);
        return "Car: " + car.getName() + ", successfully saved";
    }

    // Update a Car by ID
    public String update(Car car, Long id){
        car.setId(id);
        carRepository.save(car);
        return (car.getName() + " successfully updated!");
    }

    // Delete a Car by ID
    public String delete(Long id){
        this.carRepository.deleteById(id);
        return "Car with id: " + id + "deleted";
    }

    // List all Cars
    public List<Car> listAll(){
        return this.carRepository.findAll();
    }

    // Find a Car by ID
    public Car findById(Long id){
        return this.carRepository.findById(id).get();
    }
}
