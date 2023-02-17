package tr.com.service.service.department;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tr.com.service.entity.department.Department;
import tr.com.service.model.department.DepartmentRequest;
import tr.com.service.model.department.DepartmentResponse;
import tr.com.service.model.department.DepartmentUpdate;
import tr.com.service.repository.department.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
		this.departmentRepository = departmentRepository;
	}

	@Override
	public List<DepartmentResponse> getAll() {

		List<Department> departments = departmentRepository.findAll();
		List<DepartmentResponse> departmentResponseList = new ArrayList<DepartmentResponse>();

		for (Department department : departments) {
			DepartmentResponse departmentResponse = new DepartmentResponse();
			departmentResponse.setId(department.getId());
			departmentResponse.setName(department.getName());
			departmentResponseList.add(departmentResponse);
		}

		return departmentResponseList;
	}

	@Override
	public void add(DepartmentRequest departmentRequest) {
		Department department = new Department();
		department.setName(departmentRequest.getName());
		this.departmentRepository.save(department);
	}

	@Override
	public void delete(Long id) throws Exception {
		Optional<Department> department = departmentRepository.findById(id);

		if (department.isPresent()) {
			departmentRepository.deleteById(id);
		} else {
			throw new Exception("Id Bulunamadi");
		}
	}

	@Override
	public void update(Long id, DepartmentUpdate departmentUpdate) throws Exception {
		Optional<Department> departmentCheck = departmentRepository.findById(id);
		
		if (departmentCheck.isPresent()) {
			Department department = departmentRepository.findById(id).get();
			department.setName(departmentUpdate.getName());
			departmentRepository.save(department);
		} else {
			throw new Exception("Id Bulunamadi");
		}
	}

	@Override
	public Department findById(Long id) {
		Optional<Department> department = departmentRepository.findById(id);
		return department.get();
	}

}
