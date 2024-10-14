package com.saar.crud.payloads;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class StudentDto {
	

	private Integer id;

	@NotEmpty(message = "You can't leave it blank write somethings")
	@Size(min = 4, max = 13, message="You write name under 13 character ")
	private String name;
	
//	@Pattern(regexp = "[MF]", message = "Gender must be 'M' or 'F'")
	private String gender;
	
	@NotEmpty
	private String phone;
	
	@Pattern(
	        regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@]).+$",
	        message = "Password must contain at least one capital letter, one lowercase letter, one number, and one '@' character"
	    )
	@Size(min=5 ,max=10 , message="give password in range")
	private String email;

	@NotNull(message = "Salary cannot be null")
	private Double salary;
	

}
