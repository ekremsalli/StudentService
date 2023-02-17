package tr.com.vbt.repository.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import tr.com.vbt.entity.student.Student;

public interface StudentRepository extends JpaRepository<Student, Long>,JpaSpecificationExecutor<Student> {

}