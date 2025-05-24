package web.services;

import java.util.List;

import web.entidades.Producto;

public interface ProductoService {
	
	Producto alta(Producto producto);
	boolean eliminar(int idProducto);
	Producto modificar(Producto producto);
	
	List<Producto> todo();
	List<Producto> buscarPorSubcategoria(int idSubcategoria);
	List<Producto> buscarPorCategoria(int idCategoria);
	List<Producto> buscarPorMarca(String marca);
	List<Producto> buscarPorNombre(String nombre);
	List<Producto> buscarPorSexo(String sexo);
	Producto buscarUno(String idProducto);
}
