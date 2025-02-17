package web.restcontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	//Verifica si los id son numéricos
	public boolean esNumerico(String cadena) {
	    try {
	        Integer.parseInt(cadena); 
	        return true;
	    } catch (NumberFormatException e) {
	        return false; 
	    }
	}
	
}
