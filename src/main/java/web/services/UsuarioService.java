package web.services;

import java.util.List;
import java.util.Map;

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
	List<Map<String, Object>> obtenerNuevosUsuariosPorDia();
//	AuthResponse modificar(Usuario usuario);
	
}
