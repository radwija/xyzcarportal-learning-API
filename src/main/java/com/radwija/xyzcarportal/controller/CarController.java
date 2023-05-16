package com.radwija.xyzcarportal.controller;

import com.radwija.xyzcarportal.model.Car;
import com.radwija.xyzcarportal.service.impl.CarServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("search")
    public List<Car> searchCars(@RequestParam("by") String by, @RequestParam("keyword") String keyword) {
        List<Car> searchedCars = carService.searchCar(by, keyword);

        System.out.println(searchedCars);
        return searchedCars;
    }

    @GetMapping("viewCar")
    public ResponseEntity<Car> carDetail(@RequestParam Long cId) {
        Optional<Car> carInfo = carService.viewCarDetail(cId);

        return ResponseEntity.ok(carInfo.get());
    }
}
