package web.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import web.entidades.ArticulosEnPedido;
import web.entidades.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	Optional<Usuario> findByUsername(String username);
	public List<Usuario> findBySexo(String sexo);
}
