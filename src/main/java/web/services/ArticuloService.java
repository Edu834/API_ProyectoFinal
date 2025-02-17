package web.services;

import java.util.List;

import web.entidades.Articulo;

public interface ArticuloService {
	
	List<Articulo> todo();
	List<Articulo> buscarPorCategoria(int idCategoria);
	List<Articulo> buscarPorSubcategoria(int idSubcategoria);
	List<Articulo> buscarPorProducto(String idProducto);
	Articulo buscarUno(String idArticulo);
}
