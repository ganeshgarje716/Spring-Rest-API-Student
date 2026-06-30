package com.ganesh.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class StudentDto {

	
	
	@NotNull(message = "Name Is Required")
	private String name;
	
	@NotNull(message = "Address Is Required")
	private String address;
	
	@NotBlank(message = "Age Is Required")
	private Integer age;
	
	@NotNull(message = "Email Is Required")
	private String email;
	
	@NotNull(message = "Mobile No Is Required")
	private String mobileNo;
	
	
}
