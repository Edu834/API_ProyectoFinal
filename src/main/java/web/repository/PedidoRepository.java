package web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import web.entidades.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, String>{

	public List<Pedido> findByUsuario_idUsuario(String idUsuario);
	public List<Pedido> findByEstadoAndUsuario_idUsuario(String estado, String idUsuario);
}
