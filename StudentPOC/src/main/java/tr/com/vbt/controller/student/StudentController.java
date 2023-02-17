package tr.com.vbt.controller.student;

import java.time.LocalDate;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import tr.com.vbt.model.student.StudentRequest;
import tr.com.vbt.model.student.StudentResponse;
import tr.com.vbt.model.student.StudentUpdate;
import tr.com.vbt.service.student.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	private final StudentService studentService;

	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

	@GetMapping("/getAll")
	public List<StudentResponse> getAll() {
		return studentService.getAll();
	}

	@GetMapping("/advancedsearch")
	public List<StudentResponse> advancedSearch(@RequestParam(required=false) String studentName,
											 	   @RequestParam(required=false) String departmentName,
											       @RequestParam(required=false) LocalDate birthday,
											       @RequestParam int page,
											       @RequestParam int size) {
		return studentService.advancedSearch(studentName,departmentName,birthday,page,size);
	}



	@PostMapping("/add")
	public void add(@Valid @RequestBody() StudentRequest studentRequest) {
		this.studentService.add(studentRequest);
	}

	@DeleteMapping("/delete")
	public void delete(@RequestParam Long id) throws Exception {
		this.studentService.delete(id);
	}

	@PutMapping("/update")
	public void update(@RequestParam Long id,@Valid @RequestBody StudentUpdate studentUpdate) throws Exception {
		this.studentService.update(id, studentUpdate);
	}

}