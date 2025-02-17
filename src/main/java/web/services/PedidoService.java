package web.services;

import java.util.List;

import web.entidades.Pedido;

public interface PedidoService {
	
	List<Pedido> todo();
	List<Pedido> buscarPorUsuario(String idUsuario);
	List<Pedido> buscarPorUsuarioyEstado(String idUsuario, String estadoPedido);
	Pedido buscarUno(String idPedido);
<<<<<<< HEAD
=======
	Pedido alta(Pedido pedido);
	Pedido modificar(Pedido pedido);
>>>>>>> d0efdec5beb406f7742b1e94ad3061007a20eb03
}
