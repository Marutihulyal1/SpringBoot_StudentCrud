package org.jsp.demo.controller;

import java.util.List;

import org.jsp.demo.dto.StudentDto;
import org.jsp.demo.helper.ResponseStructure;
import org.jsp.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController // It is combination of @Controller and @ResponseBody
public class StudentController {
	@Autowired
	StudentService service;

	@RequestMapping("students")
	public ResponseStructure<StudentDto> saveStudents(@RequestBody StudentDto studentDto) {
		return service.save(studentDto);
	}

	@PostMapping("students/multiples")
	public ResponseStructure<List<StudentDto>> saveall(@RequestBody List<StudentDto> studentdtos) {
		return service.saveall(studentdtos);
	}

	@GetMapping("students/{id}") // By using @PathVariable
	public ResponseStructure<StudentDto> fetchById(@PathVariable int id) {
		return service.fetchById(id);
	}

	@GetMapping("students") // By using @RequestParam
	public ResponseStructure<StudentDto> fetchById1(@RequestParam int id) {
		return service.fetchById1(id);
	}

	@GetMapping("studentsNumber")
	public ResponseStructure<List<StudentDto>> fetchByMobile(@RequestParam long mobile) {
		return service.fetchByMobile(mobile);
	}

	@GetMapping("students/result/{result}")
	public ResponseStructure<List<StudentDto>> fetchByResult(@PathVariable String result) {
		return service.fetchByResult(result);
	}

	@GetMapping("students/{name}/{percentage}")
	public ResponseStructure<List<StudentDto>> fetchByResult(@PathVariable String name,
			@PathVariable double percentage) {
		return service.fetch(name, percentage);
	}

	@GetMapping("students/all")
	public ResponseStructure<List<StudentDto>> fetchAll() {
		return service.fetchAll();
	}

	@DeleteMapping("students/{id}")
	public ResponseStructure<StudentDto> DeleteById(@PathVariable int id) {
		return service.DeleteById(id);
	}

	@PutMapping("students/update")
	public ResponseStructure<StudentDto> update(@RequestBody StudentDto studentDto) {
		return service.update(studentDto);
	}
}
