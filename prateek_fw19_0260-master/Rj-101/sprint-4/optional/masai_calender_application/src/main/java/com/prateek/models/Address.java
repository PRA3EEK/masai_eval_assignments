package com.prateek.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data@AllArgsConstructor@NoArgsConstructor
public class Address {

	
	@NotNull
	@NotBlank
	private String city;
	@NotNull
	@NotBlank
	private String state;
	@NotNull
	@NotBlank
	private String pincode;
	@NotNull
	@NotBlank
	private String details;
	
	
}
