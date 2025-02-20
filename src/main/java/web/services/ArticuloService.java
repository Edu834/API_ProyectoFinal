package web.services;

import java.util.List;

import web.entidades.Articulo;
import web.entidades.Producto;

public interface ArticuloService {
	
	List<Articulo> todo();
	List<Articulo> buscarPorCategoria(int idCategoria);
	List<Articulo> buscarPorSubcategoria(int idSubcategoria);
	List<Articulo> buscarPorProducto(String idProducto);
	List<Articulo> buscarPorRangoPrecio(int min, int max);
	List<Articulo> buscarPorSexo(String sexo);
	List<Articulo> buscarPorSexoYCategoria(String sexo, int idCategoria);
	Articulo buscarUno(String idArticulo);
}
