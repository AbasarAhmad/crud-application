package com.saar.crud.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DeleteStudentApi {
	private StudentDto studentDto;
	private ApiResponse apiResponse;
	
}
