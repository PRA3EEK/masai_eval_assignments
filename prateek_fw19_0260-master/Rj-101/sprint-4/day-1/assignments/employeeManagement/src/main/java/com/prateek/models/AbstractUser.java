package com.prateek.models;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Embedded;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data@AllArgsConstructor@NoArgsConstructor@MappedSuperclass
public class AbstractUser {

	
	
	@NotNull
	@NotBlank
    @Size(min = 8, max = 20, message = "password must 8 to 20 characters long")
	private String password;
	@NotNull
	@NotBlank
	private String username;
	@NotNull
	@NotBlank
	private String firstName;
	@NotNull
	@NotBlank
	private String lastName;
	@Embedded
	@NotNull
	private Address address;
	@NotNull
	@NotBlank
	private String email;
	@NotNull
	@NotBlank
	@Size(min = 10, max = 10, message = "mobile number length must be 10")
	private String mobileNumber;
}
