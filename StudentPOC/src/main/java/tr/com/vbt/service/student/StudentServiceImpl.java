package tr.com.vbt.service.student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import tr.com.vbt.entity.department.Department;
import tr.com.vbt.entity.student.Student;
import tr.com.vbt.model.department.DepartmentResponse;
import tr.com.vbt.model.student.StudentRequest;
import tr.com.vbt.model.student.StudentResponse;
import tr.com.vbt.model.student.StudentUpdate;
import tr.com.vbt.repository.student.StudentRepository;
import tr.com.vbt.repository.student.StudentSpecifications;
import tr.com.vbt.service.department.DepartmentService;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private DepartmentService departmentService;

	public StudentServiceImpl(StudentRepository studentRepository, DepartmentService departmentService) {
		this.studentRepository = studentRepository;
		this.departmentService = departmentService;
	}

	@Override
	public List<StudentResponse> getAll() {
		List<Student> students = studentRepository.findAll();
		List<StudentResponse> studentResponseList = new ArrayList<StudentResponse>();

		for (Student student : students) {
			StudentResponse studentResponse = new StudentResponse();
			studentResponse.setId(student.getId());
			studentResponse.setName(student.getName());
			DepartmentResponse departmentResponse = new DepartmentResponse();
			departmentResponse.setId(student.getDepartment().getId());
			departmentResponse.setName(student.getDepartment().getName());
			studentResponse.setDepartmentResponse(departmentResponse);
			studentResponse.setBirthday(student.getBirthday());
			studentResponseList.add(studentResponse);
		}

		return studentResponseList;
	}

	@Override
	public void add(StudentRequest studentRequest) {
			
		Student student = new Student();
		student.setName(studentRequest.getName());
		Department department = departmentService.findById(studentRequest.getDepartmentid());
		student.setDepartment(department);
		student.setBirthday(studentRequest.getBirthday());
		this.studentRepository.save(student);
	}

	@Override
	public void delete(Long id) throws Exception {
		Optional<Student> student = studentRepository.findById(id);

		if (student.isPresent()) {
			studentRepository.deleteById(id);
		} else {
			throw new Exception("Id Bulunamadi");
		}
	}

	@Override
	public void update(Long id, StudentUpdate studentUpdate) throws Exception {

		Optional<Student> studentCheck = studentRepository.findById(id);
		
		if (studentCheck.isPresent()) {
				Student student = studentRepository.findById(id).get();
				Department department = departmentService.findById(studentUpdate.getDepartmentid());
				student.setDepartment(department);
				student.setName(studentUpdate.getName());
				student.setBirthday(studentUpdate.getBirthday());
				studentRepository.save(student);
		} else {
			throw new Exception("Id Bulunamadi");
		}
	}

	@Override
	public List<StudentResponse> advancedSearch(String studentName,String departmentName,LocalDate birthday,int page,int size) {
		Specification<Student> studentSpecification = StudentSpecifications.getSqlSpecification(studentName,birthday,departmentName);
		Pageable pageRequest = PageRequest.of(page, size);
		Page<Student> studentPage = studentRepository.findAll(studentSpecification,pageRequest);
		List<Student> students = new ArrayList<Student>();
		students = studentPage.getContent();
		List<StudentResponse> studentResponseList = new ArrayList<StudentResponse>();
		
		for (Student student : students) {
			StudentResponse studentResponse = new StudentResponse();
			studentResponse.setId(student.getId());
			studentResponse.setName(student.getName());
			DepartmentResponse departmentDto = new DepartmentResponse();
			departmentDto.setId(student.getDepartment().getId());
			departmentDto.setName(student.getDepartment().getName());
			studentResponse.setDepartmentResponse(departmentDto);
			studentResponse.setBirthday(student.getBirthday());
			studentResponseList.add(studentResponse);
		}
		return studentResponseList;
	}

}
