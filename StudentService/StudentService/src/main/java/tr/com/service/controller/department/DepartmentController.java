package tr.com.service.controller.department;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import tr.com.service.model.department.DepartmentRequest;
import tr.com.service.model.department.DepartmentResponse;
import tr.com.service.model.department.DepartmentUpdate;
import tr.com.service.service.department.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController {
	
	private final DepartmentService departmentService;
	
	public DepartmentController(DepartmentService departmentService) {	
		this.departmentService = departmentService;
	}

	@GetMapping("/getAll")
	public List<DepartmentResponse> getAll() {
		
		return departmentService.getAll();
	}

	@PostMapping("/add")
	public void add(@Valid @RequestBody() DepartmentRequest departmentRequest){
		this.departmentService.add(departmentRequest);
	}

	@DeleteMapping("/delete")
	public void delete(@RequestParam Long id) throws Exception {
		this.departmentService.delete(id);
	}

	@PutMapping("/update")
	public void update(@RequestParam Long id,@Valid @RequestBody DepartmentUpdate departmentUpdate) throws Exception{
		this.departmentService.update(id, departmentUpdate);
	}

}
