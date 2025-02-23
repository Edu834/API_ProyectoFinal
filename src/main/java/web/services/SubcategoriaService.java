package web.services;

import java.util.List;

import web.entidades.Subcategoria;

public interface SubcategoriaService {
	
	List<Subcategoria> todo();
	List<Subcategoria> buscarPorCategoria(int idCategoria);
	Subcategoria bucarUno(int idSubcategoria);
}
