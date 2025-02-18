package web.restcontroller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import web.entidades.ArticuloEnPedidoDTO;
import web.entidades.ArticulosEnPedido;
import web.entidades.ArticulosEnPedidoId;
import web.entidades.Pedido;
import web.entidades.Usuario;
import web.services.ArticuloServiceImpl;
import web.services.ArticulosEnPedidoServiceImpl;
import web.services.PedidoServiceImpl;
import web.services.UsuarioServiceImpl;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@CrossOrigin
@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {
	
	@Autowired
	private PedidoServiceImpl pedidoService;
	@Autowired
	private UsuarioServiceImpl usuarioService;
	@Autowired 
	private ArticulosEnPedidoServiceImpl articulosEnPedidoService;
	@Autowired 
	private ArticuloServiceImpl articuloService;
	
	
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
	
	@PostMapping("/añadirArticuloPedido")
	public ResponseEntity<Pedido> añadirArticuloPedido(@RequestBody ArticuloEnPedidoDTO articuloEnPedidoDto) {
		Usuario usuario = usuarioService.buscarUno(articuloEnPedidoDto.getIdUsuario());
		List<Pedido> pedidosCarrito = pedidoService.buscarPorUsuarioyEstado(usuario.getIdUsuario(), "Carrito");
		Pedido pedido = new Pedido();
		
		if (pedidosCarrito.isEmpty()) {
			pedido = Pedido.builder()
					.idPedido("X")
					.descripcion("Carrito de " + usuarioService.buscarUno(usuario.getIdUsuario()).getUsername())
					.fecha(new Date())
					.estado("Carrito")
					.fechaEntrega(null)
					.usuario(usuario)
					.articulosEnPedido(new ArrayList<>())
					.build();
		}else {
			pedido = pedidosCarrito.getFirst();
		}
		
		ArticulosEnPedidoId idArticuloEnPedido = new ArticulosEnPedidoId(pedido.getIdPedido(),articuloEnPedidoDto.getIdArticulo());
		ArticulosEnPedido articuloEnPedido = new ArticulosEnPedido(idArticuloEnPedido, articuloEnPedidoDto.getCantidad(), 0, "Disponible", null);
		pedido.getArticulosEnPedido().add(articuloEnPedido);
		
		if (pedidosCarrito.isEmpty()) {
			pedidoService.alta(pedido);
		}else {
			pedidoService.modificar(pedido);
		}
		
		return ResponseEntity.ok(pedido);
	}
	
	@PostMapping("/eliminarArticuloPedido")
	public ResponseEntity<Pedido> eliminarArticuloPedido(@RequestBody ArticulosEnPedidoId articulosEnPedidoId) {
		Pedido pedido = pedidoService.buscarUno(articulosEnPedidoId.getIdPedido());
		ArticulosEnPedido artEnPedido = articulosEnPedidoService.buscarUno(articulosEnPedidoId);
		
		if (pedido.getArticulosEnPedido().indexOf(artEnPedido) == -1) {
			return ResponseEntity.notFound().build();
		}
		
		pedido.getArticulosEnPedido().remove(artEnPedido);
		pedidoService.modificar(pedido);
		return ResponseEntity.ok(pedido);
	}
	
	@PostMapping("/cambiarCantidadArticuloPedido/{accion}")
	public ResponseEntity<Pedido> cambiarCantidadArticuloPedido(@RequestBody ArticulosEnPedidoId articulosEnPedidoId, @PathVariable String accion) {
		Pedido pedido = pedidoService.buscarUno(articulosEnPedidoId.getIdPedido());
		ArticulosEnPedido artEnPedido = articulosEnPedidoService.buscarUno(articulosEnPedidoId);
		
		if (artEnPedido != null) {
			if (accion.toUpperCase().equals("AUMENTAR")) {
				if (artEnPedido.getCantidad() >= articuloService.buscarUno(articulosEnPedidoId.getIdArticulo()).getStock()) {
					artEnPedido.setCantidad(artEnPedido.getCantidad());
				}else {
					artEnPedido.setCantidad(artEnPedido.getCantidad() + 1);
				}
				
			}else if (accion.toUpperCase().equals("DISMINUIR")) {
				if (artEnPedido.getCantidad() <= 1) {
					artEnPedido.setCantidad(artEnPedido.getCantidad());
				}else {
					artEnPedido.setCantidad(artEnPedido.getCantidad() - 1);
				}
				
			}else {
				return ResponseEntity.badRequest().build();
			}
		}else {
			return ResponseEntity.notFound().build();
		}
		
		pedido.getArticulosEnPedido().add(artEnPedido);
		pedidoService.modificar(pedido);
		
		return ResponseEntity.ok(pedido);
	}
	
	
	
	
	
}
