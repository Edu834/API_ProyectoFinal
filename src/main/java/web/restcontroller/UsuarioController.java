package web.restcontroller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import web.auth.AuthResponse;
import web.auth.AuthService;
import web.entidades.Role;
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
	@Autowired
	private final PasswordEncoder passwordEncoder;
	
	
	 @GetMapping({"", "/", "/home"})
	    public ResponseEntity<List<Usuario>> getAllUsers() {
	        List<Usuario> usuarios = usuarioService.todo();
	        if (usuarios.isEmpty()) {
	            return ResponseEntity.noContent().build();
	        }
	        return ResponseEntity.ok(usuarios);
	    }
	
	 @GetMapping("/{id}")
	 public ResponseEntity<UsuarioDTO> getUser(@PathVariable Integer id) {
	     Usuario usuario = usuarioService.buscarUno(id);
	     if (usuario != null) {
	         UsuarioDTO usuarioDTO = UsuarioDTO.builder()
	             .id_usuario(usuario.getIdUsuario())
	             .username(usuario.getUsername())
	             .firstname(usuario.getFirstname())
	             .lastname(usuario.getLastname())
	             .password(usuario.getPassword())
	             .email(usuario.getEmail())
	             .role(usuario.getRole())
	             .direccion(usuario.getDireccion())
	             .sexo(usuario.getSexo())
	             .telefono(usuario.getTelefono())
	             .fechaAlta(usuario.getFechaAlta())           // NUEVO
	             .fechaNacimiento(usuario.getFechaNacimiento()) // NUEVO
	             .city(usuario.getCity())                     // NUEVO
	             .province(usuario.getProvince())             // NUEVO
	             .country(usuario.getCountry())               // NUEVO
	             .zipCode(usuario.getZipCode())               // NUEVO
	             .build();
	         System.out.println("Enviando JSON: " + usuarioDTO);
	         return ResponseEntity.ok(usuarioDTO);
	     } else {
	         System.out.println("Usuario no encontrado");
	         return ResponseEntity.notFound().build();
	     }
	 }


	 @DeleteMapping("/{id}")
	 public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
	     boolean eliminado = usuarioService.eliminarUsuario(id);
	     if (eliminado) {
	         return ResponseEntity.noContent().build();
	     } else {
	         return ResponseEntity.notFound().build();
	     }
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
	            .fechaNacimiento(usuario.getFechaNacimiento())
	            .country(usuario.getCountry())
	            .province(usuario.getProvince())
	            .city(usuario.getCity())
	            .zipCode(usuario.getZipCode())
	            .build();

	    return ResponseEntity.ok(usuarioDTO);
	}
	
	  @PutMapping("/{id}")
	    public ResponseEntity<UsuarioDTO> updateUser(@PathVariable Integer id, @RequestBody UsuarioDTO updatedUser) {
	        Usuario existingUser = usuarioService.buscarUno(id);

	        if (existingUser == null) {
	            return ResponseEntity.notFound().build();
	        }

	        try {
	            // Validar y asignar el rol directamente como enum
	            if (updatedUser.getRole() != null) {
	                existingUser.setRole(updatedUser.getRole());
	            }
	        } catch (IllegalArgumentException e) {
	            return ResponseEntity.badRequest().body(null); // rol inválido
	        }

	        // Actualizar otros campos
	        existingUser.setUsername(updatedUser.getUsername());
	        existingUser.setFirstname(updatedUser.getFirstname());
	        existingUser.setLastname(updatedUser.getLastname());
	        existingUser.setEmail(updatedUser.getEmail());
	        existingUser.setDireccion(updatedUser.getDireccion());
	        existingUser.setTelefono(updatedUser.getTelefono());
	        existingUser.setSexo(updatedUser.getSexo());
	        existingUser.setFechaNacimiento(updatedUser.getFechaNacimiento());
	        existingUser.setCountry(updatedUser.getCountry());
	        existingUser.setProvince(updatedUser.getProvince());
	        existingUser.setCity(updatedUser.getCity());
	        existingUser.setZipCode(updatedUser.getZipCode());

	        // Si la contraseña no está vacía, la encriptamos
	        if (updatedUser.getPassword() != null && !updatedUser.getPassword().isBlank()) {
	            String encodedPassword = this.passwordEncoder.encode(updatedUser.getPassword());
	            existingUser.setPassword(encodedPassword);
	        }

	        Usuario savedUser = usuarioService.guardar(existingUser);

	        UsuarioDTO resultDTO = UsuarioDTO.builder()
	                .id_usuario(savedUser.getIdUsuario())
	                .username(savedUser.getUsername())
	                .firstname(savedUser.getFirstname())
	                .lastname(savedUser.getLastname())
	                .email(savedUser.getEmail())
	                .direccion(savedUser.getDireccion())
	                .telefono(savedUser.getTelefono())
	                .sexo(savedUser.getSexo())
	                .fechaNacimiento(savedUser.getFechaNacimiento())
	                .fechaAlta(savedUser.getFechaAlta())
	                .country(savedUser.getCountry())
	                .province(savedUser.getProvince())
	                .city(savedUser.getCity())
	                .zipCode(savedUser.getZipCode())
	                .role(savedUser.getRole())
	                .password("********") // no devolvemos la contraseña real
	                .build();

	        return ResponseEntity.ok(resultDTO);
	    }
	  
	  @GetMapping("/nuevos-por-dia")
	    public List<Map<String, Object>> obtenerNuevosUsuariosPorDia() {
	        return usuarioService.obtenerNuevosUsuariosPorDia();
	    }

}	
