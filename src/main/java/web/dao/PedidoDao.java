package web.dao;

import java.util.List;

import web.entidades.Pedido;

public interface PedidoDao {
	
	List<Pedido> todo();
	List<Pedido> buscarPorUsuario(String idUsuario);
	List<Pedido> buuscarPorUsuarioyEstado(String idUsuario, String estadoPedido);
	Pedido buscarUno(String idPedido);
}
