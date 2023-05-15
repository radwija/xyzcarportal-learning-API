package com.radwija.xyzcarportal.controller;

import com.radwija.xyzcarportal.model.Car;
import com.radwija.xyzcarportal.service.impl.CarServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/")
public class CarController {
    @Autowired
    private CarServiceImpl carService;

    @PostMapping("saveCar")
    public String saveCar(@RequestBody Car car) {
        carService.saveCar(car);
        return "Car saved! (From controller)";
    }
}
