package web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import web.entidades.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, String>{

	public List<Pedido> findByUsuario_idUsuario(int idUsuario);
	public List<Pedido> findByEstadoAndUsuario_idUsuario(String estado, int idUsuario);
	List<Pedido> findByUsuario_IdUsuarioAndEstado(int idUsuario, String estado);
}
