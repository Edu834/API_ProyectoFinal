package web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import web.entidades.Producto;
import web.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService{

	@Autowired
	private ProductoRepository prepo;
	
	public List<Producto> todo() {
		return prepo.findAll();
	}
	
	@Override
	public List<Producto> buscarPorSubcategoria(int idSubcategoria) {
		return prepo.findBySubcategoria_idSubcategoria(idSubcategoria);
	}

	@Override
	public List<Producto> buscarPorCategoria(int idCategoria) {
		return prepo.findBySubcategoria_Categoria_idCategoria(idCategoria);
	}

	@Override
	public List<Producto> buscarPorMarca(String marca) {
		return prepo.findByMarca(marca);
	}

	@Override
	public List<Producto> buscarPorNombre(String nombre) {
		return prepo.findByNombre(nombre);
	}

	@Override
	public Producto buscarUno(String idProducto) {
		return prepo.findById(idProducto).orElse(null);
	}

	@Override
	public List<Producto> buscarPorSexo(String sexo) {
		return prepo.findBySexo(sexo);
	}

	@Override
    public Producto alta(Producto producto) {
        try {
            if (prepo.existsById(producto.getIdProducto())) {
                return null; 
            }
            return prepo.save(producto);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public boolean eliminar(int idProducto) {
        try {
            if (prepo.existsById(String.valueOf(idProducto))) {
                prepo.deleteById(String.valueOf(idProducto));
                return true; 
            }
            return false; 
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Producto modificar(Producto producto) {
        try {
            if (!prepo.existsById(producto.getIdProducto())) {
                return null; 
            }
            return prepo.save(producto);
        } catch (Exception e) {
            return null;
        }
    }

	
}
