package web.services;

import java.util.List;
import java.util.Map;

import web.entidades.Pedido;

public interface PedidoService {
	
	List<Pedido> todo();
	List<Pedido> buscarPorUsuario(int idUsuario);
	List<Pedido> buscarPorUsuarioyEstado(int idUsuario, String estadoPedido);
	Pedido buscarUno(String idPedido);
	Pedido alta(Pedido pedido);
	Pedido modificar(Pedido pedido);
	String generarSiguienteIdPedido();
	List<Map<String, Object>> pedidosPorFecha();
}
