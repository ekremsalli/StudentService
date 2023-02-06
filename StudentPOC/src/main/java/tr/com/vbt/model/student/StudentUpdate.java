package tr.com.vbt.model.student;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentUpdate {
	@NotNull
	@Size(min=1,max=25,message = "İsim 1 ile 25 karekter arasında olmalıdır")
	private String name;
	@NotNull(message = "Department id gereklidir.")
	private Long departmentid;
	@NotNull(message = "Doğum tarihi gereklidir.")
	@Past(message = "Doğum tarihi geçmişte olmalıdır.")
	@DateTimeFormat
	private LocalDate birthday;
}
