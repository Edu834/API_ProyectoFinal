package web.dao;

import java.util.List;

import web.entidades.Articulo;

public interface ArticuloDao {
	
	List<Articulo> todo();
	List<Articulo> buscarPorCategoria(int idCategoria);
	List<Articulo> buscarPorSubcategoria(int idSubcategoria);
	List<Articulo> buscarPorProducto(String idProducto);
	Articulo buscarUno(int idArticulo);
}
