package web.restcontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import web.entidades.Pedido;
import web.services.PedidoServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {
	
	@Autowired
	private PedidoServiceImpl pedidoService;
	
	@GetMapping({"","/","/home"})
	public ResponseEntity<List<Pedido>> cargarProductosTodo() {
		List<Pedido> pedidos = pedidoService.todo(); 
		
		if (pedidos.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.ok(pedidos);
	}
	
	@GetMapping("/buscarPor/{idUsuario}")
	public ResponseEntity<List<Pedido>> buscarPorUsuario(@PathVariable String idUsuario) {
		List<Pedido> pedidos = pedidoService.buscarPorUsuario(idUsuario);
		
		if (pedidos.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.ok(pedidos);
	}
	
	@GetMapping("/buscarPor/{idUsuario}/{estado}")
	public ResponseEntity<List<Pedido>> buscarPorUsuarioyEstado(@PathVariable String idUsuario, @PathVariable String estado) {
		List<Pedido> pedidos = new ArrayList<>();
	
			if (estado != null) {
				pedidos= pedidoService.buscarPorUsuarioyEstado(idUsuario,estado);
			}else {
				ResponseEntity.badRequest().build();
			}
			
		if (pedidos.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.ok(pedidos);
	}
	
	@GetMapping("/buscarUno/{id}")
	public ResponseEntity<Pedido> buscarUno(@PathVariable String id) {
		
		Pedido pedido= pedidoService.buscarUno(id);
		
		if (pedido == null) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(pedido);
		
	}
	
	@PostMapping("/crearPedido")
	public String postMethodName(@RequestBody String entity) {
		//TODO: process POST request
		
		return entity;
	}
	
	
}
