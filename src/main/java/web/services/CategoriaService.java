package web.services;

import java.util.List;

import web.entidades.Categoria;

public interface CategoriaService {
	
	List<Categoria> todo();
	Categoria buscarUno(int idCategoria);
}
