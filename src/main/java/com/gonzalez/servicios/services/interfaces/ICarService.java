package com.gonzalez.servicios.services.interfaces;

import java.util.List;

import org.springframework.http.HttpHeaders;

import com.gonzalez.servicios.dto.CarDTO;
import com.gonzalez.servicios.dto.CreateCarDTO;
import com.gonzalez.servicios.dto.UpdateCarDTO;
import com.gonzalez.servicios.exceptions.CarExceptions;

public interface ICarService {

	public CarDTO createCar(CreateCarDTO createCarDTO) throws CarExceptions;
	
	public List<CarDTO> getAllCars();

	public CarDTO getCarById(String id) throws CarExceptions;
	
	public String deleteCar(String id) throws CarExceptions;

	public CarDTO updateCar(UpdateCarDTO updateCarDTO) throws CarExceptions;
	
	public CarDTO patchCar(String id, UpdateCarDTO updateSongDTO) throws CarExceptions;
	
	public HttpHeaders getCarHeader(String id);

	public HttpHeaders optionsCar();
	
}
