package com.radwija.xyzcarportal.service;

import com.radwija.xyzcarportal.model.Car;
import com.radwija.xyzcarportal.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CarService {
    Car saveCar(Car car);

    List<Car> searchCar(String by, String keyword, Long min, Long max);

    Optional<Car> viewCarDetail(Long cId);
}
