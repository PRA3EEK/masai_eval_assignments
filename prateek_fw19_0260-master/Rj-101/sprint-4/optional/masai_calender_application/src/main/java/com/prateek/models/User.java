package com.prateek.models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

	@NotNull
	@NotBlank
	private String firstName;
	private String lastName;
	private LocalDate dateOfBirth;
	@Embedded
	@NotNull
	private Address address;
	@NotNull
	@NotBlank
	@Email
	@Id
	private String email;
	@NotNull
	@NotBlank
	private String username;
	@NotNull
	@NotBlank
	@Size(min = 6, max = 12, message = "Password must contain 6 to 12 characters containing a lower case character, upper case character, and one digit")
	private String password;
	@NotNull
	@NotBlank
	@Size(min = 10, max = 10, message = "mobile number must 10 digits long")
	private String mobileNumber;
	@OneToMany(mappedBy = "user")
	private List<Event> events = new ArrayList<>();
	
}

