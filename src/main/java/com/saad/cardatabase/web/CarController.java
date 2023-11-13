package com.saad.cardatabase.web;

import com.saad.cardatabase.domain.Car;
import com.saad.cardatabase.domain.CarRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {
    private final CarRepository repository;

    public CarController(CarRepository repository) {
        this.repository = repository;
    }
    public Iterable<Car>getCars(){
           return repository.findAll();
    }

}
