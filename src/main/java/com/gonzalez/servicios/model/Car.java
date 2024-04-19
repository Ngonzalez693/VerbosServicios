package com.gonzalez.servicios.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Builder
@NoArgsConstructor
@Document(collection = "Cars")
public class Car {
	
	@Id
	private String id;
	private String name;
	private String brand;
	private String price;

}
