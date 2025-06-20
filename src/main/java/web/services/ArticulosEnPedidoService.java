package web.services;

import java.util.List;

import web.entidades.ArticulosEnPedido;
import web.entidades.ArticulosEnPedidoId;

public interface ArticulosEnPedidoService {
	
	List<ArticulosEnPedido> todo();
	List<ArticulosEnPedido> buscarPorPedido(String idPedido);
	ArticulosEnPedido buscarUno(ArticulosEnPedidoId articuloEnPedidoId);
	void eliminar(ArticulosEnPedido articuloEnPedido);  // Añadimos el método eliminar
	ArticulosEnPedido guardar(ArticulosEnPedido articuloEnPedido);
}
