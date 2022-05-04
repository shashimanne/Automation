package com.ata.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice

 class ExceptionController{
		@ExceptionHandler(value = VehicleNotFoundException.class)
		
		  public ResponseEntity<Object> exception(VehicleNotFoundException exception) {
	
		   return new ResponseEntity<>(" No Vehicle Found", HttpStatus.NOT_FOUND);
	
		  }
		@ExceptionHandler(value = RouteNotFoundException.class)
		
		public ResponseEntity<Object> exception(RouteNotFoundException exception) {
		
		 return new ResponseEntity<>(" Route not Found", HttpStatus.NOT_FOUND);
		
		}
		@ExceptionHandler(value = DriverNotFoundException.class)
		
		public ResponseEntity<Object> exception(DriverNotFoundException exception) {
		
		 return new ResponseEntity<>(" Driver not Found", HttpStatus.NOT_FOUND);
		
		}
		@ExceptionHandler(value =ListIsEmptyException.class)
		
		  public ResponseEntity<Object> exception(ListIsEmptyException exception) {
	
		   return new ResponseEntity<>(" List is Empty", HttpStatus.NOT_FOUND);
	
		  }
	




	}

