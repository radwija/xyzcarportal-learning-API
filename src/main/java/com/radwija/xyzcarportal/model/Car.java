package com.radwija.xyzcarportal.model;

import jakarta.persistence.*;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "car_name")
    String carName;

    String model;

    @Column(name = "make_year")
    String makeYear;

    Long price;

//    @CreatedDate
//    @Column(name = "post_date")
//    private String postDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCarName() {
        return carName;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getMakeYear() {
        return makeYear;
    }

    public void setMakeYear(String makeYear) {
        this.makeYear = makeYear;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

//    public String getPostDate() {
//        return postDate;
//    }
//
//    public void setPostDate(String postDate) {
//        this.postDate = postDate;
//    }
}
