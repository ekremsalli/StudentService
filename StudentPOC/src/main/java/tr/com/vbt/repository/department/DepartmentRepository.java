package tr.com.vbt.repository.department;

import org.springframework.data.jpa.repository.JpaRepository;

import tr.com.vbt.entity.department.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
	
}
