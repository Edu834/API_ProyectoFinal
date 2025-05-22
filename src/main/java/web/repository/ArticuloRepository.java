package web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import web.entidades.Articulo;

public interface ArticuloRepository extends JpaRepository<Articulo, String>{
	
	public List<Articulo> findByProducto_Subcategoria_Categoria_idCategoria(int idCategoria);
	public List<Articulo> findByProducto_Subcategoria_idSubcategoria(int idSubcategoria);
	public List<Articulo> findByProducto_idProducto(String idProducto);
	public List<Articulo> findByProducto_SexoAndProducto_Subcategoria_Categoria_idCategoria(String sexo, int idCategoria);
	public List<Articulo> findByProducto_Sexo(String sexo);
	public List<Articulo> findByProducto_Nombre(String nombre);
	@Query("SELECT a FROM Articulo a cross JOIN ArticulosEnPedido ap WHERE a.idArticulo = ap.id.idArticulo AND ap.id.idPedido = :idPedido")
    List<Articulo> findArticulosByPedido(@Param("idPedido") String idPedido);
}
