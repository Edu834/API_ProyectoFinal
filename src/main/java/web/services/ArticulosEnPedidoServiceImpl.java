package web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.entidades.ArticulosEnPedido;
import web.entidades.ArticulosEnPedidoId;
import web.repository.ArticulosEnPedidosRepository;

@Service
public class ArticulosEnPedidoServiceImpl implements ArticulosEnPedidoService{

	@Autowired
	private ArticulosEnPedidosRepository aeprepo;
	
	@Override
	public List<ArticulosEnPedido> todo(){
		return aeprepo.findAll();
	}
	
	@Override
	public List<ArticulosEnPedido> buscarPorPedido(String idPedido) {
		return aeprepo.findById_idPedido(idPedido);
	}
	
	@Override
	public ArticulosEnPedido buscarUno(ArticulosEnPedidoId articuloEnPedidoId) {
		return aeprepo.findById(articuloEnPedidoId).orElse(null);
	}
	@Override
    public void eliminar(ArticulosEnPedido articuloEnPedido) {
        aeprepo.delete(articuloEnPedido);
    }
	// En ArticulosEnPedidoServiceImpl:
	@Override
	public ArticulosEnPedido guardar(ArticulosEnPedido articuloEnPedido) {
	    return aeprepo.save(articuloEnPedido);
	}

}
