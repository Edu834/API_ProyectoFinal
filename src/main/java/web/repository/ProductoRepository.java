package web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import web.entidades.Producto;

public interface ProductoRepository extends JpaRepository<Producto, String>{
	
	public List<Producto> findBySubcategoria_Categoria_idCategoria(int idCategoria);
	public List<Producto> findBySubcategoria_idSubcategoria(int idSubcategoria);
	public List<Producto> findByMarca(String marca);
	public List<Producto> findByNombre(String nombre);
	public List<Producto> findBySexo(String sexo);
}
