package web.restcontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import web.entidades.Articulo;
import web.services.ArticuloServiceImpl;

@RestController
@RequestMapping("/api/articulos")
public class ArticuloController {
	
	@Autowired
	private ArticuloServiceImpl articuloService;
	
	@GetMapping({"", "/","/home"})
	public ResponseEntity<List<Articulo>> cargarArticulosTodo() {
		
		List<Articulo> articulos = articuloService.todo(); 
		
		if (articulos.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.ok(articulos);
	}
	@GetMapping("/buscarPor/{tipo}/{id}")
	public ResponseEntity<List<Articulo>> buscarPor(@PathVariable String tipo, @PathVariable String id) {
		
		List<Articulo> articulos = new ArrayList<>();
		int idParse;
		
		if(esNumerico(id)){
			if (tipo.toUpperCase().equals("CATEGORIA")) {
				idParse=Integer.parseInt(id);
				articulos= articuloService.buscarPorCategoria(idParse);
			}else if (tipo.toUpperCase().equals("SUBCATEGORIA")) {
				idParse=Integer.parseInt(id);
				articulos= articuloService.buscarPorSubcategoria(idParse);
			}else {
				return ResponseEntity.badRequest().build();
			}
		}else {
			articulos= articuloService.buscarPorProducto(id);
		}
		
		if (articulos.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.ok(articulos);
	}
	
	@GetMapping("/buscarUno/{id}")
	public ResponseEntity<Articulo> buscarUno(@PathVariable String id) {
		
		Articulo articulo= articuloService.buscarUno(id);
		
		if (articulo == null) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(articulo);
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
