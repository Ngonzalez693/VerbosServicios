package com.gonzalez.servicios.dto;

import com.gonzalez.servicios.utils.CarValidations;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Builder
@AllArgsConstructor
@Data
@ToString
public class CreateCarDTO {

	@NotBlank(message = CarValidations.CAR_NOT_EMPTY)
	@NotNull(message = CarValidations.CAR_NOT_NULL)
	private String name;

	@NotBlank(message = CarValidations.BRAND_NOT_EMPTY)
	@NotNull(message = CarValidations.BRAND_NOT_NULL)
	private String brand;

	@NotBlank(message = CarValidations.PRICE_NOT_EMPTY)
	@NotNull(message = CarValidations.PRICE_NOT_NULL)
	private String price;
	
}
