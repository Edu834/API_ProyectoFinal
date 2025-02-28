package web.services;

import java.util.List;

import web.entidades.Usuario;

public interface UsuarioService {
	
	List<Usuario> todo();
	List<Usuario> buscarPorSexo(String sexo);
	Usuario buscarUno(int idUsuario);
	Usuario buscarPorUsername(String username);
	Usuario alta(Usuario usuario);
	Usuario modificar(Usuario usuario);
}
