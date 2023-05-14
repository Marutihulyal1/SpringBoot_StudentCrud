package org.jsp.demo.service;

import java.util.List;

import org.hibernate.cache.spi.entry.StructuredCacheEntry;
import org.jsp.demo.dao.StudentDao;
import org.jsp.demo.dto.StudentDto;
import org.jsp.demo.helper.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

	@Autowired
	StudentDao dao;

	public ResponseStructure<StudentDto> save(StudentDto studentDto) {
		double percentage = (studentDto.getMaths_marks() + studentDto.getScience_marks()
				+ studentDto.getEnglish_marks()) / 3.0;
		studentDto.setPercentage(percentage);
		if (percentage >= 85) {
			studentDto.setResult("Distinction");
		} else {
			if (percentage > 60) {
				studentDto.setResult("First Class");
			} else {
				studentDto.setResult("Fail");
			}
		}

		ResponseStructure<StudentDto> structure = new ResponseStructure<>();
		structure.setMessege("Data saved successfully");
		structure.setStatuscode(HttpStatus.CREATED.value());
		structure.setData(dao.saveStudent(studentDto));
		return structure;

	}

	public ResponseStructure<List<StudentDto>> saveall(List<StudentDto> studentdtos) {
		for (StudentDto studentDto : studentdtos) {
			double percentage = (studentDto.getMaths_marks() + studentDto.getScience_marks()
					+ studentDto.getEnglish_marks()) / 3.0;
			studentDto.setPercentage(percentage);
			if (percentage >= 85) {
				studentDto.setResult("Distinction");
			} else {
				if (percentage > 60) {
					studentDto.setResult("First Class");
				} else {
					studentDto.setResult("Fail");
				}
			}
		}

		ResponseStructure<List<StudentDto>> structure = new ResponseStructure<>();
		structure.setMessege("Data saved successfully");
		structure.setStatuscode(HttpStatus.CREATED.value());
		structure.setData(dao.saveAll(studentdtos));
		return structure;
	}

	public ResponseStructure<StudentDto> fetchById(int id) {
		ResponseStructure<StudentDto> structure = new ResponseStructure<>();
		StudentDto dto = dao.fetchById(id);
		if (dto == null) {

			structure.setMessege("Data not present");
			structure.setStatuscode(HttpStatus.NOT_FOUND.value());
			structure.setData(dto);
		} else {
			structure.setMessege("Data found");
			structure.setStatuscode(HttpStatus.NOT_FOUND.value());
			structure.setData(dto);
		}
		return structure;
	}

	public ResponseStructure<StudentDto> fetchById1(int id) {

		ResponseStructure<StudentDto> structure = new ResponseStructure<>();
		StudentDto dto = dao.fetchById1(id);
		if (dto == null) {

			structure.setMessege("Data not present");
			structure.setStatuscode(HttpStatus.NOT_FOUND.value());
			structure.setData(dto);
		} else {
			structure.setMessege("Data found");
			structure.setStatuscode(HttpStatus.NOT_FOUND.value());
			structure.setData(dto);
		}
		return structure;
	}

	public ResponseStructure<List<StudentDto>> fetchByMobile(long mobile) {
		List<StudentDto> dto = dao.fetchByMobile(mobile);
		ResponseStructure<List<StudentDto>> structure = new ResponseStructure<>();
		if (dto.isEmpty())// we use in case of List only
		{
			structure.setMessege("Data not found");
			structure.setData(null);
			structure.setStatuscode(HttpStatus.NOT_FOUND.value());
		} else {
			structure.setMessege("Data found");
			structure.setData(dto);
			structure.setStatuscode(HttpStatus.FOUND.value());
		}

		return structure;

	}

	public ResponseStructure<List<StudentDto>> fetchByResult(String result) {
		List<StudentDto> dto = dao.fetchByResult(result);
		ResponseStructure<List<StudentDto>> structure = new ResponseStructure<>();
		if (dto.isEmpty())// we use in case of List only
		{
			structure.setMessege("Data not found");
			structure.setData(null);
			structure.setStatuscode(HttpStatus.NOT_FOUND.value());
		} else {
			structure.setMessege("Data found");
			structure.setData(dto);
			structure.setStatuscode(HttpStatus.FOUND.value());
		}

		return structure;
	}

	public ResponseStructure<List<StudentDto>> fetch(String name, double percentage) {
		List<StudentDto> dto = dao.fetch(name, percentage);
		ResponseStructure<List<StudentDto>> structure = new ResponseStructure<>();
		if (dto.isEmpty())// we use in case of List only
		{
			structure.setMessege("Data not found");
			structure.setData(null);
			structure.setStatuscode(HttpStatus.NOT_FOUND.value());
		} else {
			structure.setMessege("Data found");
			structure.setData(dto);
			structure.setStatuscode(HttpStatus.FOUND.value());
		}

		return structure;
	}

	public ResponseStructure<List<StudentDto>> fetchAll() {
		List<StudentDto> dto = dao.fetchAll();
		ResponseStructure<List<StudentDto>> structure = new ResponseStructure<>();
		if (dto.isEmpty())// we use in case of List only
		{
			structure.setMessege("Data not fount");
			structure.setData(null);
			structure.setStatuscode(HttpStatus.NOT_FOUND.value());
		} else {
			structure.setMessege("Data found");
			structure.setData(dto);
			structure.setStatuscode(HttpStatus.FOUND.value());
		}

		return structure;

	}

	public ResponseStructure<StudentDto> DeleteById(int id) {
		dao.DeleteById(id);
		ResponseStructure<StudentDto> structure = new ResponseStructure<>();
		structure.setData(null);
		structure.setMessege("Data Deleted Successfully");
		structure.setStatuscode(HttpStatus.FOUND.value());
		return structure;
	}

	public ResponseStructure<StudentDto> update(StudentDto studentDto) {
		double percentage = (studentDto.getMaths_marks() + studentDto.getScience_marks()
				+ studentDto.getEnglish_marks()) / 3.0;
		studentDto.setPercentage(percentage);
		if (percentage >= 85) {
			studentDto.setResult("Distinction");
		} else {
			if (percentage > 60) {
				studentDto.setResult("First Class");
			} else {
				studentDto.setResult("Fail");
			}
		}

		ResponseStructure<StudentDto> structure = new ResponseStructure<>();
		structure.setMessege("Data updated successfully");
		structure.setStatuscode(HttpStatus.CREATED.value());
		structure.setData(dao.saveStudent(studentDto));
		return structure;
	}

}
