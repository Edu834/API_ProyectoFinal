package web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import web.entidades.Pedido;
import web.repository.PedidoRepository;

@Service
public class PedidoServiceImpl implements PedidoService{

	@Autowired
	private PedidoRepository perepo;
	
    @PersistenceContext
    private EntityManager entityManager;
	
	@Override
	public List<Pedido> todo() {
		return perepo.findAll();
	}
	@Override
	public List<Pedido> buscarPorUsuario(int idUsuario) {
		return perepo.findByUsuario_idUsuario(idUsuario);
	}
	@Override
	public List<Pedido> buscarPorUsuarioyEstado(int idUsuario, String estadoPedido) {
		return perepo.findByEstadoAndUsuario_idUsuario(estadoPedido, idUsuario);
	}
	@Override
	public Pedido buscarUno(String idPedido) {
		return perepo.findById(idPedido).orElse(null);
	}
	@Override
	public Pedido alta(Pedido pedido) {
		try {
			if (perepo.existsById(pedido.getIdPedido())) {
				return null;
			}else {
				return perepo.save(pedido);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
			}
	}
	@Override
	public Pedido modificar(Pedido pedido) {
		try {
			if (perepo.existsById(pedido.getIdPedido())) {
				return perepo.save(pedido);
			}else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
			}
	}
	
}
