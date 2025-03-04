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

import web.entidades.Articulo;
import web.entidades.Categoria;
import web.entidades.Subcategoria;
import web.services.ArticuloServiceImpl;
import web.services.CategoriaServiceImpl;
import web.services.SubcategoriaServiceImpl;

@CrossOrigin
@RestController
@RequestMapping("/api/articulos")
public class ArticuloController {
	
	@Autowired
	private ArticuloServiceImpl articuloService;
	@Autowired
	private CategoriaServiceImpl categoriaServiceImpl;
	@Autowired
	private SubcategoriaServiceImpl subcategoriaServiceImpl;
	
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
	
	@GetMapping("/buscarPorSexo/{sexo}")
	public ResponseEntity<List<Articulo>> buscarPorSexo(@PathVariable String sexo) {
		List<Articulo> articulos = articuloService.buscarPorSexo(sexo); 
		List<Articulo> articulosUNISEX = articuloService.buscarPorSexo("UNISEX");
		
		if (articulos.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		articulos.addAll(articulosUNISEX);
		return ResponseEntity.ok(articulos);
	}
	@GetMapping("/buscarPorSexoYCategoria/{sexo}/{idCategoria}")
	public ResponseEntity<List<Articulo>> buscarPorSexoYCategoria(@PathVariable String sexo, @PathVariable int idCategoria) {
		
		List<Articulo> articulos = articuloService.buscarPorSexoYCategoria(sexo,idCategoria); 
		List<Articulo> articulosUNISEX = articuloService.buscarPorSexoYCategoria("UNISEX",idCategoria);
		if (articulos.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		articulos.addAll(articulosUNISEX);
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
	
	@GetMapping("/categorias")
	public ResponseEntity<List<Categoria>> cargarCategorias() {
		
		List<Categoria> categorias = categoriaServiceImpl.todo(); 
		
		if (categorias.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.ok(categorias);
	}
	@GetMapping("/subcategorias")
	public ResponseEntity<List<Subcategoria>> cargarSubcategorias() {
		
		List<Subcategoria> subcategorias = subcategoriaServiceImpl.todo(); 
		
		if (subcategorias.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.ok(subcategorias);
	}
	
	@GetMapping("/buscarPorNombreProducto/{nombreProducto}")
	public ResponseEntity<List<Articulo>> buscarPorNombreProducto(@PathVariable String nombreProducto) {
		
		List<Articulo> articulos= articuloService.buscarPorNombreProducto(nombreProducto);
		
		if (articulos.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(articulos);
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
