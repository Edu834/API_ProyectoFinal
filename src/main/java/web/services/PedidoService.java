package web.services;

import java.util.List;

import web.entidades.Pedido;

public interface PedidoService {
	
	List<Pedido> todo();
	List<Pedido> buscarPorUsuario(String idUsuario);
	List<Pedido> buscarPorUsuarioyEstado(String idUsuario, String estadoPedido);
	Pedido buscarUno(String idPedido);
}
