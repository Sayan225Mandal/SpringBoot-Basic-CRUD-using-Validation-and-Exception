package com.productservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product_details")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotNull(message = "Name is required")
	@Size(max = 10, min = 3, message = "Description must be more than 3 characters and maximum is 10")
	private String name;

	@NotNull(message = "description is required")
	@Size(max = 100, min = 10, message = "Description must be more than 4 characters and maximum is 100")
	private String description;

	@NotNull(message = "Price is required")
	private long price;

}
