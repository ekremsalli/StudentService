package tr.com.vbt.model.student;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tr.com.vbt.model.department.DepartmentResponse;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponse {
	 private Long id;
	 private String name;
	 private DepartmentResponse departmentResponse;
	 private LocalDate birthday;
}
