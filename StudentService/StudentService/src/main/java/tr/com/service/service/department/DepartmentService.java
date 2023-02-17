package tr.com.service.service.department;

import java.util.List;

import tr.com.service.entity.department.Department;
import tr.com.service.model.department.DepartmentRequest;
import tr.com.service.model.department.DepartmentResponse;
import tr.com.service.model.department.DepartmentUpdate;

public interface DepartmentService {
	List<DepartmentResponse> getAll();
	void add (DepartmentRequest departmentRequest) ;
	void delete(Long id) throws Exception;
	void update(Long id,DepartmentUpdate departmentUpdate)throws Exception;
	Department findById(Long id);
}
