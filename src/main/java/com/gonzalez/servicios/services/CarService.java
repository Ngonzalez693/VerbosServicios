package com.gonzalez.servicios.services;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import com.gonzalez.servicios.dto.CarDTO;
import com.gonzalez.servicios.dto.CreateCarDTO;
import com.gonzalez.servicios.dto.UpdateCarDTO;
import com.gonzalez.servicios.exceptions.CarExceptions;
import com.gonzalez.servicios.mappers.CarMapper;
import com.gonzalez.servicios.model.Car;
import com.gonzalez.servicios.repositories.CarRepository;
import com.gonzalez.servicios.services.interfaces.ICarService;
import com.gonzalez.servicios.utils.CarValidations;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CarService implements ICarService{

	private final CarRepository carRepository;

	@Override
	public CarDTO createCar(CreateCarDTO createCarDTO) throws CarExceptions {
		
		return CarMapper.domainToGetSongDto(carRepository.save(CarMapper.createCarDtoToDomain(createCarDTO)));
	}

	@Override
	public List<CarDTO> getAllCars() {
		
		return CarMapper.domainToGetSongDto(carRepository.findAll());
	}

	@Override
	public CarDTO getCarById(String id) throws CarExceptions {
		
		if (!carRepository.existsById(id))
			throw new CarExceptions(CarValidations.CAR_NOT_FOUND);
		return CarMapper.domainToGetSongDto(carRepository.findById(id).get());
	}

	@Override
	public String deleteCar(String id) throws CarExceptions {
		
		if (!carRepository.existsById(id))
			throw new CarExceptions(String.format(CarValidations.CAR_NOT_FOUND, id));

		carRepository.delete(carRepository.findById(id).get());

		return String.format(CarValidations.CAR_DELETED, id);
	}

	@Override
	public CarDTO updateCar(UpdateCarDTO updateCarDTO) throws CarExceptions {
		
		if (!carRepository.existsById(updateCarDTO.getId()))
			throw new CarExceptions(CarValidations.CAR_NOT_FOUND);
		return CarMapper.domainToGetSongDto(carRepository.save(CarMapper.updateCarDtoToDomain(updateCarDTO)));
	}

	@Override
	public CarDTO patchCar(String id, UpdateCarDTO updateSongDTO) throws CarExceptions {

		if (!carRepository.existsById(id))
			throw new CarExceptions(CarValidations.CAR_NOT_FOUND);

		Car car = carRepository.findById(id).orElseThrow(() -> new CarExceptions(CarValidations.CAR_NOT_FOUND));

		if (updateCarDTO.getName() != null) {
			car.setName(updateCarDTO.getName());
		}
		if (updateCarDTO.getBrand() != null) {
			car.setBrand(updateCarDTO.getBrand());
		}
		if (updateCarDTO.getPrice() != null) {
			car.setPrice(updateCarDTO.getPrice());
		}

		carRepository.save(car);
		return CarMapper.domainToGetCarDto(car);
	}

	@Override
	public HttpHeaders getCarHeader(String id) {

		HttpHeaders httpHeaders = new HttpHeaders();

		if (carRepository.existsById(id)) {
			Car car = carRepository.findById(id).get();
			httpHeaders.add("name", car.getName());
			httpHeaders.add("brand", car.getBrand());
		}
		return httpHeaders;
	}

	@Override
	public HttpHeaders optionsCar() {
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("HTTPS", "GETTERS, POST, UPDATE, PATCH, DELETE, HEAD, OPTIONS");
		httpHeaders.add("Permitidos", "GETTERS, POST, UPDATE, PATCH, DELETE, HEAD, OPTIONS");
		return httpHeaders;
	}

	
}
