package web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.entidades.Pedido;
import web.repository.PedidoRepository;

@Service
public class PedidoServiceImpl implements PedidoService{

	@Autowired
	private PedidoRepository perepo;
	
	@Override
	public List<Pedido> todo() {
		return perepo.findAll();
	}
	@Override
	public List<Pedido> buscarPorUsuario(String idUsuario) {
		return perepo.findByUsuario_idUsuario(idUsuario);
	}
	@Override
	public List<Pedido> buscarPorUsuarioyEstado(String idUsuario, String estadoPedido) {
		return perepo.findByEstadoAndUsuario_idUsuario(estadoPedido, idUsuario);
	}
	@Override
	public Pedido buscarUno(String idPedido) {
		return perepo.findById(idPedido).orElse(null);
	}
	
}
