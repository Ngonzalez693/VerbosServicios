package com.gonzalez.servicios.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Builder
@AllArgsConstructor
@Data
@ToString
public class CarDTO {

	private String id;
	private String name;
	private String brand;
	private String price;
	
}
