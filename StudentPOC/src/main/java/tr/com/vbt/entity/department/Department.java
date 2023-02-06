package tr.com.vbt.entity.department;


import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import tr.com.vbt.entity.student.Student;


@Entity
@Table(name = "department")
public class Department {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
    private Long id;
    
    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "department")
    private List<Student> student;

	public Department(Long id, String name, List<Student> student) {
		super();
		this.id = id;
		this.name = name;
		this.student = student;
	}
	
	public Department() {
		super();
	}
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Student> getStudents() {
		return student;
	}

	public void setStudents(List<Student> student) {
		this.student = student;
	}

}
