package web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import web.entidades.Subcategoria;

public interface SubcategoriaRepository extends JpaRepository<Subcategoria, Integer>{
	
	public List<Subcategoria> findByCategoria_idCategoria(int idCategoria);
}
