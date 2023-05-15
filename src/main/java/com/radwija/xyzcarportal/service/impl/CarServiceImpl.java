package com.radwija.xyzcarportal.service.impl;

import com.radwija.xyzcarportal.model.Car;
import com.radwija.xyzcarportal.repository.CarRepository;
import com.radwija.xyzcarportal.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private CarRepository carRepository;


    @Override
    public String saveCar(Car car) {
        carRepository.save(car);
        return "Car saved!";
    }
}
