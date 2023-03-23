package com.prateek.enitites;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
	@Size(min = 6, max = 6, message = "Pincode must be 6 digits long")
	private String pincode;
	@NotNull
	@NotBlank
	private String details;
	
}
