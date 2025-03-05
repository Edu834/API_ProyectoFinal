package web.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import lombok.RequiredArgsConstructor;
import web.auth.AuthResponse;
import web.auth.AuthService;
import web.entidades.Usuario;
import web.entidades.UsuarioDTO;
import web.entidades.UsuarioRequest;
import web.entidades.UsuarioResponse;
import web.services.UsuarioServiceImpl;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin
@RequiredArgsConstructor
public class UsuarioController {
	@Autowired
	private UsuarioServiceImpl usuarioService;
	
	
	
	@GetMapping({"","/","/home"})
	public ResponseEntity<List<Usuario>> getAllUsers(@PathVariable Integer id){
		List<Usuario> usuarios = usuarioService.todo();
		if(usuarios.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(usuarios);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UsuarioDTO> getUser(@PathVariable Integer id){
		Usuario usuario = usuarioService.buscarUno(id);
		if(usuario!=null) {
			UsuarioDTO usuarioDTO = UsuarioDTO.builder()
					.id_usuario(usuario.getIdUsuario())
					.username(usuario.getUsername())
					.firstname(usuario.getFirstname())
					.lastname(usuario.getLastname())
					.password(usuario.getPassword())
					.email(usuario.getEmail())
					.direccion(usuario.getDireccion())
					.sexo(usuario.getSexo())
					.telefono(usuario.getTelefono())
					.build();
			return ResponseEntity.ok(usuarioDTO);
		}
		return ResponseEntity.notFound().build();
	}
	
	

	@GetMapping("/me")
	public ResponseEntity<UsuarioDTO> getAuthenticatedUser() {
	    // Obtener el usuario autenticado desde el contexto de seguridad
	    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

	    if (authentication == null || !authentication.isAuthenticated()) {
	        return ResponseEntity.status(401).build(); // No autorizado
	    }

	    Object principal = authentication.getPrincipal();
	    String username;

	    if (principal instanceof UserDetails) {
	        username = ((UserDetails) principal).getUsername();
	    } else {
	        username = principal.toString(); // Si solo se tiene el nombre como String
	    }

	    // Buscar al usuario en la base de datos por su nombre de usuario
	    Usuario usuario = usuarioService.buscarPorUsername(username);
	    if (usuario == null) {
	        return ResponseEntity.notFound().build();
	    }

	    // Convertir a DTO y devolver los datos
	    UsuarioDTO usuarioDTO = UsuarioDTO.builder()
	            .id_usuario(usuario.getIdUsuario())
	            .username(usuario.getUsername())
	            .firstname(usuario.getFirstname())
	            .lastname(usuario.getLastname())
	            .email(usuario.getEmail())
	            .direccion(usuario.getDireccion())
	            .password(usuario.getPassword())
	            .sexo(usuario.getSexo())
	            .telefono(usuario.getTelefono())
	            .fechaAlta(usuario.getFechaAlta())
	            .build();

	    return ResponseEntity.ok(usuarioDTO);
	}
}	
