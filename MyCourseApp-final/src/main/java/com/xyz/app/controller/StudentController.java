package com.xyz.app.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xyz.app.entities.Student;
import com.xyz.app.request.CreateStudentRequest;
import com.xyz.app.request.InQueryRequest;
import com.xyz.app.request.UpdateStudentRequest;
import com.xyz.app.response.StudentResponse;
import com.xyz.app.service.StudentService;

@RestController
@RequestMapping("/api/student/")
public class StudentController {
	
	// Error < Warn < Info < Debug < Trace
	
	Logger logger = LoggerFactory.getLogger(StudentController.class);

	@Autowired
	StudentService studentService;
	
	@GetMapping("getAll")
	public List<StudentResponse> getAllStudents () {
		
		
		logger.error("Inside Error");
		logger.warn("Inside Warning");
		logger.info("Inside Info");
		logger.debug("Inside Debug");
		logger.trace("Inside Trace");
		
		
		List<Student> studentList = studentService.getAllStudents();
		List<StudentResponse> studentResponseList = new ArrayList<StudentResponse>();
		
		studentList.stream().forEach(student -> {
			studentResponseList.add(new StudentResponse(student));
		});
		
		return studentResponseList;
	}
	
	@GetMapping("getByFirstNameIn")
	public List<StudentResponse> getByFirstNameIn (@RequestBody InQueryRequest inQueryRequest) {//
		/* Requestbody in json
		 * {"firstNames": ["Yamini","Shiva"]}
		 */
		logger.info(" Logging request info into console:  inQueryRequest = "+inQueryRequest);
		
		List<Student> studentList = studentService.getByFirstNameIn(inQueryRequest);
		
		List<StudentResponse> studentResponseList = new ArrayList<StudentResponse>();
		
		studentList.stream().forEach(student -> {
			studentResponseList.add(new StudentResponse(student));
		});
		
		logger.info("Logging response info into console:  studentResponseList = "+studentResponseList);
		
		return studentResponseList;
	}
	
	@PostMapping("create")  //(
	public StudentResponse createStudent (@Valid  @RequestBody CreateStudentRequest createStudentRequest) {
		logger.info(" Logging request info into console:  createStudentRequest = "+createStudentRequest);
		Student student = studentService.createStudent(createStudentRequest);
		logger.info(" Logging request info into console:  student = "+student);
		return new StudentResponse(student);
	}
	
	
	
	@PutMapping("update")//@Valid
	public StudentResponse updateStudent ( @Valid @RequestBody UpdateStudentRequest updateStudentRequest) {
		logger.info(" Logging request info into console:  UpdateStudentRequest = "+updateStudentRequest);

		Student student = studentService.updateStudent(updateStudentRequest);
		logger.info(" Logging request info into console:  student = "+student);

		return new StudentResponse(student);
	}
	
	/*@DeleteMapping("delete")
	public String deleteStudent (@RequestParam long id) {
		return studentService.deleteStudent(id);
	}*/
	
	@DeleteMapping("delete/{id}")
	public String deleteStudent (@PathVariable long id) {
		return studentService.deleteStudent(id);
	}
	
	@GetMapping("getByFirstName/{firstName}")
	public List<StudentResponse> getByFirstName (@PathVariable String firstName) {
		List<Student> studentList = studentService.getByFirstName(firstName);
		
		List<StudentResponse> studentResponseList = new ArrayList<StudentResponse>();
		
		studentList.stream().forEach(student -> {
			studentResponseList.add(new StudentResponse(student));
		});
		
		return studentResponseList;
	}
	
	@GetMapping("getByFirstNameAndLastName/{firstName}/{lastName}")
	public StudentResponse getByFirstNameAndLastName (@PathVariable String firstName, 
			@PathVariable String lastName) {
		return new StudentResponse(studentService.getByFirstNameAndLastName(firstName, lastName));
	}
	
	@GetMapping("getByFirstNameOrLastName/{firstName}/{lastName}")
	public List<StudentResponse> getByFirstNameOrLastName (@PathVariable String firstName, 
			@PathVariable String lastName) {
		List<Student> studentList = studentService.getByFirstNameOrLastName(firstName, lastName);
		
		List<StudentResponse> studentResponseList = new ArrayList<StudentResponse>();
		
		studentList.stream().forEach(student -> {
			studentResponseList.add(new StudentResponse(student));
		});
		
		return studentResponseList;
	}
	
	
	
	@GetMapping("getAllWithPagination")
	public List<StudentResponse> getAllStudentsWithPagination (@RequestParam int pageNo,
			@RequestParam int pageSize) {
		
		List<Student> studentList = studentService.
				getAllStudentsWithPagination(pageNo, pageSize);
		
		List<StudentResponse> studentResponseList = new ArrayList<StudentResponse>();
		
		studentList.stream().forEach(student -> {
			studentResponseList.add(new StudentResponse(student));
		});
		
		return studentResponseList;
	}
	
	@GetMapping("getAllWithSorting")
	public List<StudentResponse> getAllStudentsWithSorting () {
		
		List<Student> studentList = studentService.getAllStudentsWithSorting();
		
		List<StudentResponse> studentResponseList = new ArrayList<StudentResponse>();
		
		studentList.stream().forEach(student -> {
			studentResponseList.add(new StudentResponse(student));
		});
		
		return studentResponseList;
	}
	
	@PutMapping("updateFirstName/{id}/{firstName}")
	public String updateStudentWithJpql (@PathVariable Long id, @PathVariable String firstName) {
		return studentService.updateStudentWithJpql(id, firstName)+ " Student(s) updated";
	}
	
	@DeleteMapping("deleteByFirstName/{firstName}")
	public String deleteStudent (@PathVariable String firstName) {
		return studentService.deleteStudent(firstName) + " Student(s) deleted";
	}
	
	@GetMapping("/getByCity/{city}")
	public List<StudentResponse> getByCity(@PathVariable String city) {
		
		List<Student> studentList = studentService.getByCity(city);
		
		List<StudentResponse> studentResponseList = new ArrayList<StudentResponse>();
		
		studentList.stream().forEach(student -> {
			studentResponseList.add(new StudentResponse(student));
		});
		
		return studentResponseList;
	}
}
