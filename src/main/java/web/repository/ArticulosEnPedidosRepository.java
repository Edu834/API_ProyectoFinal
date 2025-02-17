package web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import web.entidades.ArticulosEnPedido;
import web.entidades.ArticulosEnPedidoId;

public interface ArticulosEnPedidosRepository extends JpaRepository<ArticulosEnPedido, ArticulosEnPedidoId>{

	List<ArticulosEnPedido> findById_Pedido_idPedido(String idPedido);
	List<ArticulosEnPedido> findById_idPedido(String idPedido);
}
