package org.jsp.demo.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.demo.dto.StudentDto;
import org.jsp.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentDao {
	@Autowired
	StudentRepository repository;

	public StudentDto saveStudent(StudentDto studentDto) {
		return repository.save(studentDto);
	}

	public List<StudentDto> saveAll(List<StudentDto> studentdtos) {
		return repository.saveAll(studentdtos);
	}

	public StudentDto fetchById(int id) {
		Optional<StudentDto> op = repository.findById(id);
		if (op.isEmpty()) {
			return null;
		} else {
			return op.get();
		}
	}

	public StudentDto fetchById1(int id) {
		Optional<StudentDto> op = repository.findById(id);
		if (op.isEmpty()) {
			return null;
		} else {
			return op.get();
		}
	}

	public List<StudentDto> fetchByMobile(long mobile) {
		return repository.findByMobile(mobile);

	}

	public List<StudentDto> fetchByResult(String result) {
		return repository.findByResult(result);
	}

	public List<StudentDto> fetch(String name, double percentage) {
		return repository.findByNameAndPercentage(name, percentage);
	}

	public List<StudentDto> fetchAll() {
		return repository.findAll();
	}

	public void DeleteById(int id) {
		repository.deleteById(id);

	}

}
