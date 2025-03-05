package web.entidades;

import java.sql.Date;
import java.time.LocalDateTime;

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
	LocalDateTime fechaAlta;
}
