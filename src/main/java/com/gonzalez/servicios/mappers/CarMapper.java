package com.gonzalez.servicios.mappers;

import com.gonzalez.servicios.dto.CarDTO;
import com.gonzalez.servicios.dto.CreateCarDTO;
import com.gonzalez.servicios.dto.UpdateCarDTO;
import com.gonzalez.servicios.model.Car;

import java.util.List;
import java.util.stream.Collectors;

public class CarMapper {

	public static List<CarDTO> domainToGetSongDto(List<Car> cars) {
		return cars.stream().map(car -> domainToGetCarDto(car)).collect(Collectors.toList());
	}

	public static Car updateCarDtoToDomain(UpdateCarDTO updateCarDTO) {
		return Car.builder().id(updateCarDTO.getId()).name(updateCarDTO.getName())
				.brand(updateCarDTO.getBrand()).price(updateCarDTO.getPrice()).build();
	}

	public static Car createSongDtoToDomain(CreateCarDTO createCarDTO) {
		return Car.builder().name(createCarDTO.getName()).brand(createCarDTO.getBrand())
				.price(createCarDTO.getPrice()).build();
	}

	public static CarDTO domainToGetCarDto(Car car) {
		return CarDTO.builder().id(car.getId()).name(car.getName()).brand(car.getBrand()).price(car.getPrice())
				.build();
	}
	
}
