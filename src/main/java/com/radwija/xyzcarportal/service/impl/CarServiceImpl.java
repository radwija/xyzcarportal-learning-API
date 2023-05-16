package com.radwija.xyzcarportal.service.impl;

import com.radwija.xyzcarportal.model.Car;
import com.radwija.xyzcarportal.repository.CarRepository;
import com.radwija.xyzcarportal.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private CarRepository carRepository;

    @Override
    public String saveCar(Car car) {
        carRepository.save(car);
        return "Car saved!";
    }

    @Override
    public List<Car> searchCar(String by, String keyword) {
        if (by.equalsIgnoreCase("carName")) {
            return carRepository.searchCarByName(keyword);
        } else if (by.equalsIgnoreCase("makeYear")) {
            return carRepository.searchCarByMakeYear(keyword);
        } else if (by.equalsIgnoreCase("model")) {
            return carRepository.searchCarByModel(keyword);
        } else if (by.equalsIgnoreCase("price")) {
            return carRepository.searchCarByPrice(keyword);
        }
        return null;
    }

    @Override
    public Optional<Car> viewCarDetail(Long cId) {
        return carRepository.findById(cId);
    }
}
