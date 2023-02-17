package tr.com.vbt.repository.student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import tr.com.vbt.entity.department.Department;
import tr.com.vbt.entity.student.Student;

public class StudentSpecifications {
	
	public static Specification<Student> getSqlSpecification(String studentName,LocalDate birthday,String departmentName) {
		return (Root<Student> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> criteriaBuilder
				.and(getPrediction(query, root, criteriaBuilder, studentName,birthday,departmentName));
	}

	public static Predicate getPrediction(CriteriaQuery<?> query, Root<Student> root, CriteriaBuilder criteriaBuilder,
			String studentName,LocalDate birthday,String departmentName) {
		List<Predicate> predicates = new ArrayList<>();
		if (studentName != null) {
			predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("name"), studentName)));
		}
		if (birthday != null) {
			predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("birthday"), birthday)));
		}
		if(departmentName != null) {
			Join<Department, Student> studentsDepartment = root.join("department");
			predicates.add(criteriaBuilder.and(criteriaBuilder.equal(studentsDepartment.get("name"), departmentName)));
		}

		return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
		
	}

}
