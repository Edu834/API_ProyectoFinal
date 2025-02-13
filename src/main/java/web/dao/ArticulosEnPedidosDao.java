package web.dao;

import java.util.List;

import web.entidades.ArticulosEnPedido;
import web.entidades.Pedido;

public interface ArticulosEnPedidosDao {
	
	List<ArticulosEnPedido> buscarPorPedido(Pedido pedido);
	
}
