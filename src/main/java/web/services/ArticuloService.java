package web.services;

import java.util.List;

import web.entidades.Articulo;

public interface ArticuloService {
	
	List<Articulo> todo();
	List<Articulo> buscarPorCategoria(int idCategoria);
	List<Articulo> buscarPorSubcategoria(int idSubcategoria);
	List<Articulo> buscarPorProducto(String idProducto);
	List<Articulo> buscarPorSexo(String sexo);
	List<Articulo> buscarPorSexoYCategoria(String sexo, int idCategoria);
	List<Articulo> buscarPorNombreProducto(String nombre);
	Articulo buscarUno(String idArticulo);
	List<Articulo> findArticulosByPedido(String idPedido);
}
