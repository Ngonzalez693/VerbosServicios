package com.gonzalez.servicios.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.gonzalez.servicios.model.Car;

@Repository
public class CarRepository extends MongoRepository<Car, String>{

}
