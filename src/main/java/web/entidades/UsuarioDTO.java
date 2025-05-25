package web.entidades;

import java.sql.Date;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {
	int id_usuario;
	String username;
	String firstname;
	String lastname;
	String password;
	String email;
	String direccion;
	String sexo;
	String telefono;
	Role role;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
	LocalDateTime fechaAlta;
	Date fechaNacimiento;
	String country;
	String province;
	String city;
	Integer zipCode;
}
