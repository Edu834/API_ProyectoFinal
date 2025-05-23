package web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import web.entidades.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, String>{

	public List<Pedido> findByUsuario_idUsuario(int idUsuario);
	public List<Pedido> findByEstadoAndUsuario_idUsuario(String estado, int idUsuario);
	public List<Pedido> findByUsuario_IdUsuarioAndEstado(int idUsuario, String estado);
	@Query("SELECT p.fecha as fecha, COUNT(p) as cantidad FROM Pedido p WHERE estado != 'Carrito' GROUP BY p.fecha")
	public List<Object[]> countByFecha();
}
