package tr.com.service.model.student;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tr.com.service.model.department.DepartmentResponse;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponse {
	 private Long id;
	 private String name;
	 private DepartmentResponse departmentResponse;
	 private LocalDate birthday;
}
