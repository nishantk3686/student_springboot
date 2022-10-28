package com.student.repository;
import com.student.model.StudentCar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<StudentCar,Integer>{

}
