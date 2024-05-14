package com.car.booking.Car;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.booking.Car.CarException.CarNotFoundException;

@Service
public class CarServiceImpl implements CarService {

    private final Logger logger = LoggerFactory.getLogger(getClass().toGenericString());

    @Autowired
    private CarRepository carRepository;

    @Override
    public List<CarEntity> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public CarEntity getCarById(Long id) {
        logger.info("getCarById", id);
        CarEntity carEntity = carRepository.findById(id).orElse(null);
        logger.info("getCarById", carEntity);
        if (carEntity == null) {
            throw new CarNotFoundException("Car with id " + id + " not found");
        }

        return carEntity;
    }

    @Override
    public CarEntity addOrUpdateCar(CarEntity carEntity) {
        logger.info("addOrUpdateCar", carEntity);
        CarEntity carEntityResult = carRepository.save(carEntity);
        logger.info("addOrUpdateCar - carEntityResult", carEntityResult);

        return carEntity;
    }

    @Override
    public void deleteCar(Long id) {
        logger.info("deleteCar", id);
        carRepository.deleteById(id);
    }

}
