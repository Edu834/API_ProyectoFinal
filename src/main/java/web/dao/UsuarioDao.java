package web.dao;

import java.util.List;

import web.entidades.Usuario;

public interface UsuarioDao {
	
	List<Usuario> todo();
	List<Usuario> buscarPorSexo(String sexo);
	Usuario buscarUno(String idUsuario);
	Usuario buscarPorUsername(String username);
}
