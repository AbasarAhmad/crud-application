package com.saar.crud.exceptions;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResourceNotFoundException extends RuntimeException {

		String resourceName;
		String fieldName;
		long fieldValue;
		public ResourceNotFoundException(String resourceName,String fieldName,long fieldValue) {
		super(String.format("User is not found Id: %s",fieldValue));
		System.out.println("This is over exception");
		this.resourceName=resourceName;
		this.fieldName=fieldName;
		this.fieldValue=fieldValue;
	}
}
