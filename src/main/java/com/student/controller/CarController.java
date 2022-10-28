package com.student.controller;

import java.util.List;
import com.student.model.StudentCar;
import com.student.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {

	//dependency injection for service
	@Autowired
	private CarService service;
	
	//handling request
	@RequestMapping(method=RequestMethod.POST ,value="/car")
	public ResponseEntity<String> addCar(@RequestBody StudentCar c1) {
		String status=service.addCar(c1);
		if(status!=null)
			return new ResponseEntity<>(status,HttpStatus.CREATED);
		else
			return new ResponseEntity<>(status,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	//sending list of Car
	@RequestMapping(method=RequestMethod.GET ,value="/car")
	public ResponseEntity<List<StudentCar>> getLaptop() {
		return new ResponseEntity<>(service.getCar(),HttpStatus.OK);
	}
	@RequestMapping(method=RequestMethod.PUT, value="/car")
	public ResponseEntity<String> updateLaptop(@RequestBody StudentCar l1){
		
		String status=service.updatecar(l1);
		if(status!=null)
		{
		return new ResponseEntity<>(status,HttpStatus.OK );
		}
		else {
			return new ResponseEntity<>(status,HttpStatus.INTERNAL_SERVER_ERROR);
		}	
	}
	
	//api to delete the cars
	@RequestMapping(method=RequestMethod.DELETE,value="/car/{carid}")
	public ResponseEntity<String> deleteLaptop(@PathVariable int carid){
		
		String status=service.deleteCar(carid);
		if(status!=null)
		{
		return new ResponseEntity<>(status,HttpStatus.OK );
		}
		else {
			return new ResponseEntity<>(status,HttpStatus.INTERNAL_SERVER_ERROR);
		}	
	}
	
	//getting sorted list of cars based on specific field of table 
	@GetMapping("/getcars/{field}")
	public ResponseEntity<List<StudentCar>> getCars(@PathVariable String field){
		
		
		return new ResponseEntity<>(service.getCar(field),HttpStatus.OK);
		
	}
	
}