package com.gonzalez.servicios.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.gonzalez.servicios.dto.CreateCarDTO;
import com.gonzalez.servicios.dto.ErrorDTO;
import com.gonzalez.servicios.dto.MsgDTO;
import com.gonzalez.servicios.dto.UpdateCarDTO;
import com.gonzalez.servicios.exceptions.CarExceptions;
import com.gonzalez.servicios.services.CarService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE,
		RequestMethod.OPTIONS, RequestMethod.HEAD, RequestMethod.PATCH })
@RequiredArgsConstructor
@RestController
@RequestMapping("/cars")
@Slf4j
public class CarController {

	private final CarService carService;

	@GetMapping(path = "/getCars")
	public ResponseEntity getAllCars() {
		return new ResponseEntity(carService.getAllCars(), HttpStatus.OK);
	}

	@GetMapping(path = "/getCar/{id}")
	public ResponseEntity getCarById(@PathVariable String id) {
		try {
			return new ResponseEntity(carService.getCarById(id), HttpStatus.OK);
		} catch (CarExceptions ex) {
			return new ResponseEntity(ErrorDTO.builder().error(ex.getMessage()).build(), HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping(path = "/createCar")
	public ResponseEntity createCar(@RequestBody CreateCarDTO createCarDTO) {
	    try {
	        return new ResponseEntity(carService.createCar(createCarDTO), HttpStatus.CREATED);
	    } catch (CarExceptions ex) {
	        return new ResponseEntity(ErrorDTO.builder().error(ex.getMessage()).build(), HttpStatus.BAD_REQUEST);
	    }
	}

	@PutMapping(path = "/updateCar")
	public ResponseEntity updateCar(@RequestBody UpdateCarDTO updateCarDTO) {
		try {
			return new ResponseEntity(carService.updateCar(updateCarDTO), HttpStatus.OK);
		} catch (CarExceptions ex) {
			return new ResponseEntity(ErrorDTO.builder().error(ex.getMessage()).build(), HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping(path = "/deleteCar/{id}")
	public ResponseEntity deleteCar(@PathVariable String id) {
		try {
			return new ResponseEntity(MsgDTO.builder().message(carService.deleteCar(id)).build(), HttpStatus.OK);
		} catch (CarExceptions ex) {
			return new ResponseEntity(ErrorDTO.builder().error(ex.getMessage()).build(), HttpStatus.BAD_REQUEST);
		}
	}

	@PatchMapping(path = "/patchCar/{id}")
	public ResponseEntity patchCar(@PathVariable String id, @RequestBody UpdateCarDTO updateSongDTO) {
		try {
			return new ResponseEntity(carService.patchCar(id, updateCarDTO), HttpStatus.OK);
		} catch (CarExceptions ex) {
			return new ResponseEntity(ErrorDTO.builder().error(ex.getMessage()).build(), HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(path = "/headerCar/{id}", method = RequestMethod.HEAD)
	public ResponseEntity headerCar(@PathVariable String id) {
		return new ResponseEntity(carService.getCarHeader(id), HttpStatus.OK);
	}

	@RequestMapping(path = "/optionsCar", method = RequestMethod.OPTIONS)
	public ResponseEntity optionsCars() {
		return new ResponseEntity(carService.optionsCar(), HttpStatus.OK);
	}
}
