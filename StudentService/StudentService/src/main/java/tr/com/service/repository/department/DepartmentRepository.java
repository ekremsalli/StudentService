package tr.com.service.repository.department;

import org.springframework.data.jpa.repository.JpaRepository;

import tr.com.service.entity.department.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
	
}
