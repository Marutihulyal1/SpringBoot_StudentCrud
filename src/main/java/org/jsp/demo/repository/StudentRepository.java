package org.jsp.demo.repository;

import java.util.List;

import org.jsp.demo.dto.StudentDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentDto, Integer> {

	List<StudentDto> findByMobile(long mobile);

	List<StudentDto> findByResult(String result);

	@Query("select x from StudentDto x where name=?1 and percentage=?2")
	List<StudentDto> findByNameAndPercentage(String name, double percentage);

}
