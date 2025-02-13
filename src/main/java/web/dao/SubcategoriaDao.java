package web.dao;

import java.util.List;

import web.entidades.Subcategoria;

public interface SubcategoriaDao {
	
	List<Subcategoria> todo();
	List<Subcategoria> buscarPorCategoria(int idCategoria);
	Subcategoria bucarUno(int idSubcategoria);
}
