package web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import web.entidades.ArticulosEnPedido;
import web.entidades.ArticulosEnPedidoId;
import web.entidades.Pedido;

public interface ArticulosEnPedidosRepository extends JpaRepository<ArticulosEnPedido, ArticulosEnPedidoId>{
	
	List<ArticulosEnPedido> findById_Pedido(Pedido pedido);
}
