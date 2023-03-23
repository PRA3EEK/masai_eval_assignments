package com.prateek.firApplication.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity@Data@AllArgsConstructor@NoArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotNull
	@NotBlank
	private String firstName;
	@NotNull
	@NotBlank
	private String lastName;
	@NotNull
	@NotBlank
	@Size(min = 10, max = 10)
	private String mobileNumber;
	@Embedded@NotNull
	private Address address;
	private LocalDate dateOfBirth;
	@NotNull
    private Integer age;
	@NotNull
	@NotBlank
    private String gender;
	@NotNull
	@NotBlank
    private String username;
	@NotNull
	@NotBlank
	@Size(min = 6, max = 12)
    private String password;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Fir> firsFiled = new ArrayList<>(); 
}
