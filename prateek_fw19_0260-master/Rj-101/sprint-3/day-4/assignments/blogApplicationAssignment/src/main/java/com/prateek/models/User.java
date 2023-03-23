package com.prateek.models;

import java.util.ArrayList;
import java.util.List;

import io.micrometer.common.lang.NonNull;
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

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotNull(message = "Username cannot be null")
	@NotBlank(message = "username cannot be blank")
	private String username;
	@NotNull(message = "Password cannot be null")
	@NotBlank(message = "Password cannot be blank")
	@Size(min = 3, max = 25, message = "password length must be between 3 and 25")
	private String password;
	@NotNull(message = "Address cannot be null")
	@Embedded
	private Address address;
	@NotNull(message = "mobileNumber cannot be null")
	@NotBlank(message = "mobileNumber cannot be blank")
	@Size(min = 10, max = 10, message = "length of the number must be 10")
	private String mobileNumber;
    @NotNull(message = "email cannot be null")
    @NotBlank(message = "email cannot be blank")
	private String email;
	
	
	@OneToMany(mappedBy = "user")
	private List<Post> posts = new ArrayList<>();
	@OneToMany(mappedBy = "user")
	private List<Comment> comments = new ArrayList<>();
	
	
}
