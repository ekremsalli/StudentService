package tr.com.vbt.model.department;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentRequest {
	@NotNull(message = "Department ismi gereklidir.")
	@Size(min=1,max=25,message = "İsim 1 ile 25 karekter arasında olmalıdır")
	private String name;
}

