package web.entidades;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioRequest {
	int id_usuario;
	String username;
	String firstname;
	String lastname;
	String password;
	String email;
	String direccion;
	String sexo;
	String telefono;

}
