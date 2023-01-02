package com.example.Student.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Student.entity.Student;
import com.example.Student.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentController {
	
@Autowired
private StudentService studentService;


Logger log = LogManager.getLogger("Student");





@PostMapping("/save")
public ResponseEntity<Student> createStudent(@RequestBody Student student){
	
	Student saveStudent = studentService.createStudent(student);

log.debug("testAPI started: " + saveStudent);
log.info("testAPI started: " + saveStudent);
log.error("Errorrrrrrrrrrr");

	
	return new ResponseEntity<Student>(saveStudent,HttpStatus.CREATED);
}



@GetMapping("/student")
public ResponseEntity<List<Student>>  getAllStudent(){
	System.out.println("Executed getStudent method()....");
	List<Student> student = studentService.getAllStudent();
	return new ResponseEntity<List<Student>>(student,HttpStatus.OK);
	

}
	

@GetMapping("student/id")
public ResponseEntity<Student> getById(@RequestParam("id") Long id){
	Student student1 = studentService.getById(id);
	return new ResponseEntity<Student>(student1,HttpStatus.OK);
}

@GetMapping("student/{id}")
public ResponseEntity<Student> getById(@PathVariable long id){
	Student student1 = studentService.getById(id);
	return new ResponseEntity<Student>(student1,HttpStatus.OK);
}


@GetMapping("student/{name}")
public ResponseEntity<List<Student>> getByName(@PathVariable String name){
	List<Student> student1 = studentService.findByName(name);
	return new ResponseEntity <List<Student>> (student1,HttpStatus.OK);
}

@GetMapping("student/name")
public ResponseEntity<List<Student>> findByName(@RequestParam("firstName") String name){
	List<Student> student1 = studentService.findByName(name);
	
	return new ResponseEntity<List<Student>>(student1,HttpStatus.OK);
}



@PutMapping("/update")
public ResponseEntity<Student> updateStudent(@RequestBody Student student){
	Student student1 = studentService.updateStudent(student);
	
	return new ResponseEntity<Student>(student1,HttpStatus.ACCEPTED);
}


@DeleteMapping("/delete/{id}")
public ResponseEntity<?> deleteDetails(@PathVariable long id)
{
	studentService.deleteById(id);
	return new ResponseEntity<>("deleted sucessfully", HttpStatus.OK);
}











}
