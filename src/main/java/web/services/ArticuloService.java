package web.services;

import java.util.List;

import web.entidades.Articulo;

public interface ArticuloService {
	
	List<Articulo> todo();
	List<Articulo> buscarPorCategoria(int idCategoria);
	List<Articulo> buscarPorSubcategoria(int idSubcategoria);
	List<Articulo> buscarPorProducto(String idProducto);
	List<Articulo> buscarPorRangoPrecio(int min, int max);
	Articulo buscarUno(String idArticulo);
}
