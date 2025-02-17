package web.services;

import java.util.List;

import web.entidades.Producto;

public interface ProductoService {

	List<Producto> todo();
	List<Producto> buscarPorSubcategoria(int idSubcategoria);
	List<Producto> buscarPorCategoria(int idCategoria);
	List<Producto> buscarPorMarca(String marca);
	List<Producto> buscarPorNombre(String nombre);
	Producto buscarUno(String idProducto);
}
