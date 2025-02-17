package web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import web.entidades.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, String>{
	
	public Usuario findByUsername(String username);
	public List<Usuario> findBySexo(String sexo);
}
