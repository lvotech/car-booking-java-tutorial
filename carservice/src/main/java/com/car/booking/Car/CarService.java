package com.car.booking.Car;

import java.util.List;

public interface CarService {
    List<CarEntity> getAllCars();
    CarEntity getCarById(Long id);
    CarEntity addOrUpdateCar(CarEntity car);
    void deleteCar(Long id);
}
