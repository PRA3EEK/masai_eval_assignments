package com.prateek.enitites;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Valid
@Entity@Data@AllArgsConstructor@NoArgsConstructor
public class User {
   
	@Id
	@NotNull
	@NotBlank
	@Email
	private String email;
	@NotNull
	@NotBlank
	private String firstName;
	@NotNull
	@NotBlank
	private String lastName;
	@NotNull
	@NotBlank
	@Size(min = 10, max = 10, message = "Mobile number must be 10 digits long")
	private String mobileNumber;
	
	private LocalDate dateOfBirth;
	@NotNull
	@NotBlank
	private String username;
	@NotNull
	@NotBlank
	@Size(min = 6, max = 12, message = "password length must be between 6 and 12")
	private String password;
	@NotNull
	@Embedded
	private Address address;
	@OneToMany(mappedBy = "user", targetEntity = com.prateek.enitites.Email.class)
	private List<com.prateek.enitites.Email> mails = new ArrayList<>();
}
