package web.entidades;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name="usuarios")
public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="id_usuario")
	private String idUsuario;
	private String username;
	private String firstname;
	private String lastname;
	private String password;
	private String direccion;
	private String email;
	private String sexo;
	private String telefono;
	
	@ManyToMany
	@JoinTable(
		name="usuario_con_perfiles"
		, joinColumns={
			@JoinColumn(name="id_usuario")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_perfil")
			}
		)
	private List<Perfil> perfiles;
}