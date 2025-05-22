package web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import web.entidades.Articulo;
import web.entidades.Producto;
import web.repository.ArticuloRepository;

@Service
public class ArticuloServiceImpl implements ArticuloService{
	
	@PersistenceContext
    private EntityManager em;
	
	@Autowired
	private ArticuloRepository arepo;

	@Override
	public List<Articulo> todo() {
		return arepo.findAll();
	}

	@Override
	public List<Articulo> buscarPorCategoria(int idCategoria) {
		return arepo.findByProducto_Subcategoria_Categoria_idCategoria(idCategoria);
	}

	@Override
	public List<Articulo> buscarPorSubcategoria(int idSubcategoria) {
		return arepo.findByProducto_Subcategoria_idSubcategoria(idSubcategoria);
	}

	@Override
	public List<Articulo> buscarPorProducto(String idProducto) {
		return arepo.findByProducto_idProducto(idProducto);
	}

	@Override
	public Articulo buscarUno(String idArticulo) {
		return arepo.findById(idArticulo).orElse(null);
	}

	@Override
	public List<Articulo> buscarPorSexo(String sexo) {
		return arepo.findByProducto_Sexo(sexo);
	}

	@Override
	public List<Articulo> buscarPorSexoYCategoria(String sexo, int idCategoria) {
		return arepo.findByProducto_SexoAndProducto_Subcategoria_Categoria_idCategoria(sexo, idCategoria);
	}

	@Override
	public List<Articulo> buscarPorNombreProducto(String nombre) {
		return arepo.findByProducto_Nombre(nombre);
	}

	@Override
	public List<Articulo> findArticulosByPedido(String idPedido) {
		return arepo.findArticulosByPedido(idPedido);
	}

	@Override
    public String obtenerRutaFotoFrontal(String idArticulo) {
        String sql = """
            SELECT g.foto_frontal
            FROM articulos a
            JOIN productos p ON a.id_producto = p.id_producto
            JOIN galerias g ON p.id_galeria = g.id_galeria
            WHERE a.id_articulo = :idArticulo
        """;

        try {
            return (String) em.createNativeQuery(sql)
                    .setParameter("idArticulo", idArticulo)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
	@Override
	public Producto obtenerProductoDesdeArticulo(String idArticulo) {
	    Articulo articulo = arepo.findById(idArticulo).orElse(null);
	    
	    if (articulo != null) {
	        return articulo.getProducto(); // ← incluye galería, subcategoría, etc.
	    }

	    return null;
	}

}
