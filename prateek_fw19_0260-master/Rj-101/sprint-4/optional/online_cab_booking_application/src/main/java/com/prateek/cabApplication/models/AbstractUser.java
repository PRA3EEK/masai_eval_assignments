package com.prateek.cabApplication.models;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.web.bind.MethodArgumentNotValidException;

import jakarta.persistence.Embedded;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.Constraint;
import jakarta.validation.Valid;
import jakarta.validation.ValidationException;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@MappedSuperclass
public class AbstractUser {
    
	@NotNull
	@NotBlank
	private String firstName;
	@NotNull
	@NotBlank
	private String lastName;
	@NotNull
	@NotBlank
	private String username;
	@NotNull
	@NotBlank
	@Size(min = 6, max = 12)
	private String password;
	@NotNull
	@NotBlank
	@Email
	private String email;
	@NotNull
	@NotBlank
	@Size(min = 10, max = 10)
	private String mobileNumber;
	@Embedded@NotNull
	private Address address;
	
	
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
		
		for(char i='0' ; i<'9' ; i++)
		{
			for(int j=0 ; j<firstName.length() ; j++)
			{
				if(firstName.charAt(j) == i)
				{  
					throw new ValidationException("First name should not contains any numeric value");
				}
			}
		}
		
		Matcher firstNameMatch = p.matcher(firstName);
		if(firstNameMatch.find())
		{
			throw new ValidationException("First name must not contain any special character");
		}
		
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
		for(char i='0' ; i<'9' ; i++)
		{
			for(int j=0 ; j<lastName.length() ; j++)
			{
				if(lastName.charAt(j) == i)
				{  
					throw new ValidationException("last name should not contains any numeric value");
				}
			}
		}
		
		Matcher lastNameMatch = p.matcher(lastName);
		if(lastNameMatch.find())
		{
			throw new ValidationException("Last name must not contain any special character");
		}
		this.lastName = lastName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
		
		boolean passwordContainsNumeric = false;
		boolean passwordContainsUpperCase = false;
		boolean passwordContainsLowerCase = false;
		boolean passwordContainsSpecialCharacter = false;
		
		
		for(char i='0' ; i<'9' ; i++)
		{
			for(int j=0 ; j<password.length() ; j++)
			{
				if(passwordContainsNumeric)
				{
					break;
				}
				if(password.charAt(j) == i)
				{  
					passwordContainsNumeric = true;
					break;
				}
			}
		}
		
		if(!passwordContainsNumeric)
			 throw new ValidationException("Password must contain a numeric value from 0 to 9");
		
		for(char i='a' ; i<='z' ; i++)
		{
			if(passwordContainsLowerCase)
			{
				break;
			}
			for(int j=0 ; j<password.length() ; j++)
			{
				if(password.charAt(j)-i == 0)
				{
					passwordContainsLowerCase = true;
					break;
				}
			}
		}
		if(!passwordContainsLowerCase)
		   throw new ValidationException("Password must contain a lower case character");
		
		
		for(char i='A' ; i<='Z' ; i++)
		{
			if(passwordContainsUpperCase)
			{
				break;
			}
			for(int j=0 ; j<password.length() ; j++)
			{
				if(password.charAt(j)-i == 0)
				{
					passwordContainsUpperCase = true;
					break;
				}
			}
		}
		if(!passwordContainsUpperCase)
		   throw new ValidationException("Password must contains an upper case character");
		
		Matcher passwordMatcher = p.matcher(password);
		if(passwordMatcher.find())
		{
			passwordContainsSpecialCharacter = true;
		}
		
		if(!passwordContainsSpecialCharacter)
	        throw new ValidationException("Password must contain a special character");
		
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public AbstractUser(@NotNull @NotBlank String firstName, @NotNull @NotBlank String lastName,
			@NotNull @NotBlank String username, @NotNull @NotBlank String password,
			@NotNull @NotBlank @Email String email, @NotNull @NotBlank @Size(min = 10, max = 10) String mobileNumber,
			@NotNull Address address) {
		super();
		setFirstName(firstName);
        setLastName(lastName);
		this.username = username;
		setPassword(password);
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.address = address;
	}
	
	
	public AbstractUser() {
		// TODO Auto-generated constructor stub
	}
}
