package com.car.booking.Car;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.booking.Car.CarException.CarNotFoundException;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    @Override
    public List<CarEntity> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public CarEntity getCarById(Long id) {
        CarEntity carEntity = carRepository.findById(id).orElse(null);
        if (carEntity == null) {
            throw new CarNotFoundException("Car with id " + id + " not found");
        }
        
        return carEntity;
    }

    @Override
    public CarEntity addOrUpdateCar(CarEntity car) {
        return carRepository.save(car);
    }

    @Override
    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }
    
}
