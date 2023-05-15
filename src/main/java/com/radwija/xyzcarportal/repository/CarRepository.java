package com.radwija.xyzcarportal.repository;

import com.radwija.xyzcarportal.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    @Query(value = "SELECT c FROM Car c WHERE c.carName LIKE '%' || :keyword || '%'")
    public List<Car> searchCarByName(@Param("keyword") String keyword);

    @Query(value = "SELECT c FROM Car c WHERE c.makeYear LIKE '%' || :keyword || '%'")
    public List<Car> searchCarByMakeYear(@Param("keyword") String keyword);

    @Query(value = "SELECT c FROM Car c WHERE c.model LIKE '%' || :keyword || '%'")
    public List<Car> searchCarByModel(@Param("keyword") String keyword);

    @Query(value = "SELECT c FROM Car c WHERE c.price LIKE '%' || :keyword || '%'")
    public List<Car> searchCarByPrice(@Param("keyword") String keyword);

}
