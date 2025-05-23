package web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import web.entidades.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, String>{

	public List<Pedido> findByUsuario_idUsuario(int idUsuario);
	public List<Pedido> findByEstadoAndUsuario_idUsuario(String estado, int idUsuario);
	public List<Pedido> findByUsuario_IdUsuarioAndEstado(int idUsuario, String estado);
	@Query("SELECT p.fecha AS fecha, " +
	           "COUNT(*) AS pedidoCount, " +
	           "SUM(a.cantidad) AS totalCantidad, " +
	           "SUM(a.precioFinal) AS totalPrecioFinal " +
	           "FROM Pedido p LEFT JOIN p.articulosEnPedido a " +
	           "WHERE p.estado != 'carrito' " +
	           "GROUP BY p.fecha")
	public List<Object[]> countByFecha();
}
