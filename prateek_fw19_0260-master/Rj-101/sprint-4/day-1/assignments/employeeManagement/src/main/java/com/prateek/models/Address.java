package com.prateek.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

	@NotNull
	@NotBlank
	@Size(min = 6, max = 6, message = "pincode should be 6 characters long")
	private String pincode;
	@NotNull
	@NotBlank
	private String city;
	@NotNull
	@NotBlank
	private String State;
	@NotNull
	@NotBlank
	private String details;
	
}
