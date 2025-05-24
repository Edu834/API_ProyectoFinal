package web.restcontroller;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import web.entidades.Producto;
import web.services.ProductoServiceImpl;
@CrossOrigin
@RestController
@RequestMapping("/api/productos")
public class ProductoController {
	
	@Autowired
	private ProductoServiceImpl productoService;
	
	@GetMapping({"","/","/home"})
	public ResponseEntity<List<Producto>> cargarProductosTodo() {
		List<Producto> productos = productoService.todo(); 
		
		if (productos.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.ok(productos);
	}
	
	@GetMapping("/buscarPor/{tipo}/{id}")
	public ResponseEntity<List<Producto>> buscarPor(@PathVariable String tipo, @PathVariable String id) {
		List<Producto> productos = new ArrayList<>();
		int idParse;
		
		if(esNumerico(id)){
			if (tipo.toUpperCase().equals("CATEGORIA")) {
				idParse=Integer.parseInt(id);
				productos= productoService.buscarPorCategoria(idParse);
			}else if (tipo.toUpperCase().equals("SUBCATEGORIA")) {
				idParse=Integer.parseInt(id);
				productos= productoService.buscarPorSubcategoria(idParse);
			}else {
				return ResponseEntity.badRequest().build();
			}
			
		}else {
			if (tipo.toUpperCase().equals("MARCA")) {
				productos= productoService.buscarPorMarca(id);
			}else if (tipo.toUpperCase().equals("NOMBRE")) {
				productos= productoService.buscarPorNombre(id);
			}else {
				return ResponseEntity.badRequest().build();
			}
		}
		
		if (productos.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.ok(productos);
	}
	
	@GetMapping("/buscarUno/{id}")
	public ResponseEntity<Producto> buscarPor(@PathVariable String id) {
		
		Producto producto= productoService.buscarUno(id);
		
		if (producto == null) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(producto);
	}
	
    @PostMapping
    public ResponseEntity<?> altaProducto(@RequestBody Producto producto) {
        try {
            Producto nuevoProducto = productoService.alta(producto);
            if (nuevoProducto == null) {
                return ResponseEntity.badRequest().body("No se pudo crear el producto. Verifique el ID o los datos.");
            }
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevoProducto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al crear el producto: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> modificarProducto(@PathVariable String id, @RequestBody Producto producto) {
        try {
            if (!id.equals(producto.getIdProducto())) {
                return ResponseEntity.badRequest().body("El ID en la URL no coincide con el ID del producto.");
            }
            Producto productoModificado = productoService.modificar(producto);
            if (productoModificado == null) {
                return ResponseEntity.badRequest().body("No se pudo modificar el producto. Verifique si existe.");
            }
            return ResponseEntity.ok(productoModificado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al modificar el producto: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarProducto(@PathVariable String id) {
        try {
            boolean eliminado = productoService.eliminar(Integer.parseInt(id));
            if (!eliminado) {
                return ResponseEntity.badRequest().body("No se pudo eliminar el producto. Verifique si existe.");
            }
            return ResponseEntity.ok().build();
        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest().body("El ID debe ser numérico.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al eliminar el producto: " + e.getMessage());
        }
    }
	
	public boolean esNumerico(String cadena) {
	    try {
	        Integer.parseInt(cadena); 
	        return true;
	    } catch (NumberFormatException e) {
	        return false; 
	    }
	}
	
}
