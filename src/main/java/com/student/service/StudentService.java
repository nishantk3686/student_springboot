package com.student.service;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import com.student.model.Student;
import com.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
	
	//injecting repository
	@Autowired
	private StudentRepository repo;
	
	//adding Students to database
	public String addStudent(Student s1) {
		Student _s2=repo.save(s1);
		
		if(_s2!=null) {
			return "student added.....@"+new Date();
		}
		else {
			return null;
			}
	}
	
	//Retriving all students from Database
	public List<Student> getAllstds(){
		
		
		return repo.findAll();
		
	}
	
	//updating the student if he/she already existed
	public String updateStudent(Student s1) {
		
		Student _s2=repo.save(s1);
		if(_s2!=null) {
			return "Student updated!..."+new Date();
		}
		else {
			return null;
		}
		
	}
	//deleting the student based on stdid if it is existed
	public String deleteStudent(int stdid) {
		
		Optional<Student> _d1=repo.findById(stdid);
		
		if(_d1!=null) {
			repo.deleteById(stdid);
			return "Student deleted";
		}
		else {
			return null;
		}
		
	}
}
