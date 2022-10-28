package com.student.service;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import com.student.model.StudentCar;
import com.student.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;


@Service
public class CarService {
	//dependency injection for repository
	@Autowired
	private CarRepository carrepo;
	//adding Cars to Database
	public String addCar(StudentCar c1) {
		String msg=null;
		StudentCar _c2=carrepo.save(c1);
		if(_c2!=null) {
			msg= "car added!... @"+new Date();
		}
		else {
			msg=null;
		}
		return msg;
	}
	
	//retriving list of Cars
	public List<StudentCar> getCar(){
		return carrepo.findAll();
	}
		
	//updating the existing car in db
	public String updatecar(StudentCar c1)
	{
		StudentCar _c2=carrepo.save(c1);
		if(_c2!=null) {
			return "Car updated "+new Date();
		}
		else {
			return null;
		}
	}
	
	//deleting la based on carid if it is existed in db
	public String deleteCar(int carid) {
		
		Optional<StudentCar> _l1=carrepo.findById(carid);
		if(_l1!=null) {
			carrepo.deleteById(carid);
			return "Car deleted";
		}
		else {
			return null;
		}
	}
	
	//sorting the list of cars based on a specific field of a table
	public List<StudentCar> getCar(String field){
		
		
		return carrepo.findAll(Sort.by(Direction.DESC,field));
		
	}
	
}