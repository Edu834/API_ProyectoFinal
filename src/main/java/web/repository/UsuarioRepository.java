package web.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import web.entidades.ArticulosEnPedido;
import web.entidades.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	@Query("SELECT FUNCTION('DATE', u.fechaAlta) AS fecha, COUNT(u) " +
	           "FROM Usuario u " +
	           "WHERE MONTH(u.fechaAlta) = MONTH(CURRENT_DATE) " +
	           "AND YEAR(u.fechaAlta) = YEAR(CURRENT_DATE) " +
	           "GROUP BY FUNCTION('DATE', u.fechaAlta) " +
	           "ORDER BY fecha")
	List<Object[]> contarNuevosUsuariosPorDia();
	Optional<Usuario> findByUsername(String username);
	public List<Usuario> findBySexo(String sexo);
}
