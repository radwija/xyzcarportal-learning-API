package com.radwija.xyzcarportal.controller;

import com.radwija.xyzcarportal.model.Car;
import com.radwija.xyzcarportal.service.CarService;
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
@CrossOrigin("http://localhost:3000")
public class CarController {
    @Autowired
    private CarService carService;

    @PostMapping("saveCar")
    public Car saveCar(@RequestBody Car car) {
        carService.saveCar(car);
        return car;
    }

    @GetMapping("cars")
    public List<Car> showAllCars() {
        return carService.showAllCars();
    }

    @GetMapping("search")
    public List<Car> searchCars(@RequestParam("by") String by,
                                @RequestParam(value = "keyword", required = false) String keyword,
                                @RequestParam(value = "min", required = false) Long min,
                                @RequestParam(value = "max", required = false) Long max) {
        List<Car> searchedCars = carService.searchCar(by, keyword, min, max);

        System.out.println(searchedCars);
        return searchedCars;
    }

    @GetMapping("viewCar")
    public ResponseEntity<Car> carDetail(@RequestParam Long cid) {
        Optional<Car> carInfo = carService.viewCarDetail(cid);

        if (carInfo.isEmpty()) {
            return null;
        } else {
            return ResponseEntity.ok(carInfo.get());
        }
    }
}
