package web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import web.entidades.Articulo;

public interface ArticuloRepository extends JpaRepository<Articulo, String>{
	
	public List<Articulo> findByProducto_Subcategoria_Categoria_idCategoria(int idCategoria);
	public List<Articulo> findByProducto_Subcategoria_idSubcategoria(int idSubcategoria);
	public List<Articulo> findByProducto_idProducto(String idProducto);
	public List<Articulo> findByPrecioBetween(int min, int max);
	public List<Articulo> findByProducto_SexoAndProducto_Subcategoria_Categoria_idCategoria(String sexo, int idCategoria);
	public List<Articulo> findByProducto_Sexo(String sexo);
}
