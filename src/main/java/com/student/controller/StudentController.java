package com.student.controller;
import java.util.List;
import com.student.model.Student;
import com.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	
	//injecting service
	@Autowired
	private StudentService service;
	
	//adding student
	@PostMapping("/student")
	public ResponseEntity<String> addStudent(@RequestBody Student s1){
		String status=service.addStudent(s1);
		
		if(status!=null) {
			//sending response entity along with status
			return new ResponseEntity<>(status,HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<>(status,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	//Retriving Students
	@GetMapping("/Student")
	public ResponseEntity<List<Student>> getAllstds(){
		 return new ResponseEntity<>(service.getAllstds(),HttpStatus.OK);
	}
	//api to update the Student
	@PutMapping("/student")
	public ResponseEntity<String> updateStudent(@RequestBody Student s1){
		
		String status=service.updateStudent(s1);
		if(status!=null) {
			return new ResponseEntity<>(status,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(status,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	//api to delete the Student
	@DeleteMapping("/Student/{stdid}")
	public ResponseEntity<String> deleteStudent(@PathVariable int stdid){
		
		String status=service.deleteStudent(stdid);
		if(status!=null) {
			return new ResponseEntity<>(status,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(status,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}