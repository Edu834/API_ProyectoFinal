package web.restcontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import web.entidades.Usuario;
import web.services.UsuarioServiceImpl;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;

import web.entidades.LoginDTO;
import web.entidades.Perfil;

import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioServiceImpl usuarioService;
	
	@GetMapping({"","/","/home"})
	public ResponseEntity<List<Usuario>> cargarUsuariosTodo() {
		List<Usuario> usuarios = usuarioService.todo(); 
		
		if (usuarios.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.ok(usuarios);
	}
	
	@GetMapping("/buscarPorSexo/{sexo}")
	public ResponseEntity<List<Usuario>> buscarPorSexo(@PathVariable String sexo) {
		List<Usuario> usuarios = usuarioService.buscarPorSexo(sexo);
		
		if (usuarios.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.ok(usuarios);
	}
	
	@GetMapping("/buscarUnoPor/{tipo}/{valor}")
	public ResponseEntity<Usuario> buscarUnoPor(@PathVariable String tipo, @PathVariable String valor) {
		
		Usuario usuario= new Usuario();
		
		if (tipo.toUpperCase().equals("ID")) {
			usuario= usuarioService.buscarUno(valor);
			
		} else if (tipo.toUpperCase().equals("USERNAME")) {
			usuario= usuarioService.buscarPorUsername(valor);
			
		} else {
			ResponseEntity.badRequest().build();
		}
		
		if (usuario == null) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(usuario);
	}
	
	@PostMapping("/login")
	public ResponseEntity<Usuario> login(@RequestBody LoginDTO loginDto) {
		
		Usuario usuario = usuarioService.buscarPorUsername(loginDto.getUsername());

		if(usuario == null || !usuario.getPassword().equals(loginDto.getPassword())){
			return ResponseEntity.badRequest().build();
		}
		usuario.setPassword("");
		return ResponseEntity.ok(usuario);
	}
	
	@PostMapping("/registro")
	public ResponseEntity<Usuario> register(@RequestBody Usuario usuario) {
		
		List<Perfil> perfiles = new ArrayList<>();
		perfiles.add(new Perfil(1,"Cliente"));
		usuario.setPerfiles(perfiles);
		
		Usuario newUsuario = usuarioService.alta(usuario);
		if (newUsuario == null) {
			return ResponseEntity.noContent().build();
		}
		newUsuario.setPassword("");
		return ResponseEntity.ok(newUsuario);
	}
	
	@PostMapping("/editarUsuario")
	public ResponseEntity<Usuario> editarUsuario(@RequestBody Usuario usuario) {
		
		usuario.setPerfiles(usuarioService.buscarUno(usuario.getIdUsuario()).getPerfiles());
		Usuario updatedUsuario = usuarioService.modificar(usuario);
		
		if (updatedUsuario == null) {
			return ResponseEntity.noContent().build();
		}
		updatedUsuario.setPassword("");
		return ResponseEntity.ok(updatedUsuario);
	}
	
	
}
