package web.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import web.auth.AuthResponse;
import web.entidades.Usuario;
import web.entidades.UsuarioDTO;
import web.entidades.UsuarioRequest;

public interface UsuarioService {
	
	List<Usuario> todo();
	List<Usuario> buscarPorSexo(String sexo);
	Usuario buscarUno(int idUsuario);
	Usuario buscarPorUsername(String username);
	Usuario alta(Usuario usuario);
	boolean eliminarUsuario(int idUsuario);
	Usuario guardar(Usuario usuario);
//	AuthResponse modificar(Usuario usuario);
	
}
