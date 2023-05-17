package com.radwija.xyzcarportal.service;

import com.radwija.xyzcarportal.model.Car;
import com.radwija.xyzcarportal.repository.CarRepository;
import com.radwija.xyzcarportal.service.impl.CarServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CarServiceTest {
    @InjectMocks
    CarServiceImpl carService;

    @Mock
    CarRepository carRepository;

    @Test
    public void saveCarTest() {
        Car car = new Car();
        car.setCarName("Toyota Avanza");
        car.setModel("Avanza");
        car.setMakeYear("2020");
        car.setPrice(20000000L);

        Mockito.when(carRepository.save(car)).thenReturn(car);
        Car savedCar = carService.saveCar(car);
        Assert.assertEquals(car, savedCar);

    }
}
