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
    public Car saveCar(Car car) {
        return carRepository.save(car);
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
    public Optional<Car> viewCarDetail(Long cid) {
        return carRepository.findById(cid);
    }
}
