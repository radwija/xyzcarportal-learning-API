package com.radwija.xyzcarportal.service;

import com.radwija.xyzcarportal.model.Car;
import com.radwija.xyzcarportal.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface CarService {
    String saveCar(Car car);
}
