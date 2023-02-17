package tr.com.vbt.service.department;

import java.util.List;

import tr.com.vbt.entity.department.Department;
import tr.com.vbt.model.department.DepartmentRequest;
import tr.com.vbt.model.department.DepartmentResponse;
import tr.com.vbt.model.department.DepartmentUpdate;

public interface DepartmentService {
	List<DepartmentResponse> getAll();
	void add (DepartmentRequest departmentRequest) ;
	void delete(Long id) throws Exception;
	void update(Long id,DepartmentUpdate departmentUpdate)throws Exception;
	Department findById(Long id);
}
