package web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.entidades.Articulo;
import web.repository.ArticuloRepository;

@Service
public class ArticuloServiceImpl implements ArticuloService{
	
	@Autowired
	private ArticuloRepository arepo;

	@Override
	public List<Articulo> todo() {
		return arepo.findAll();
	}

	@Override
	public List<Articulo> buscarPorCategoria(int idCategoria) {
		return arepo.findByProducto_Subcategoria_Categoria_idCategoria(idCategoria);
	}

	@Override
	public List<Articulo> buscarPorSubcategoria(int idSubcategoria) {
		return arepo.findByProducto_Subcategoria_idSubcategoria(idSubcategoria);
	}

	@Override
	public List<Articulo> buscarPorProducto(String idProducto) {
		return arepo.findByProducto_idProducto(idProducto);
	}

	@Override
	public Articulo buscarUno(String idArticulo) {
		return arepo.findById(idArticulo).orElse(null);
	}

	
}
