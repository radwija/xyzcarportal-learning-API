package com.radwija.xyzcarportal.service;

import com.radwija.xyzcarportal.model.Car;
import com.radwija.xyzcarportal.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarService {
    String saveCar(Car car);

    List<Car> searchCar(String by, String keyword);
}
