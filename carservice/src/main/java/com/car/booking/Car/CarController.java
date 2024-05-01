package com.car.booking.Car;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping
    public List<CarEntity> getAllCars() {
        return carService.getAllCars();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarEntity> getCarById(@PathVariable Long id) {
        CarEntity carEntity = carService.getCarById(id);
        return ResponseEntity.ok(carEntity);
    }

    @PostMapping
    public ResponseEntity<CarEntity> addCar(@RequestBody CarEntity carEntity) {
        CarEntity newCarEntity = carService.addOrUpdateCar(carEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCarEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarEntity> updateCar(@PathVariable Long id, @RequestBody CarEntity carEntity) {
        carEntity.setId(id);
        CarEntity updatedCarEntity = carService.addOrUpdateCar(carEntity);
        return ResponseEntity.ok(updatedCarEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
        return ResponseEntity.noContent().build();
    }
}
