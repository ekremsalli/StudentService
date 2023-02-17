package tr.com.service.service.student;
import java.time.LocalDate;
import java.util.List;

import tr.com.service.model.student.StudentRequest;
import tr.com.service.model.student.StudentResponse;
import tr.com.service.model.student.StudentUpdate;


public interface StudentService {
	List<StudentResponse> getAll();
	void add (StudentRequest studentRequest) ;
	void delete(Long id) throws Exception;
	void update(Long id,StudentUpdate studentUpdate)throws Exception;
	List<StudentResponse> advancedSearch(String studentName,String departmentName,LocalDate birthday,int page,int size);
}
