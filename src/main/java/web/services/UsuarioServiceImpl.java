package web.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import web.auth.AuthResponse;
import web.entidades.Usuario;
import web.entidades.UsuarioDTO;
import web.entidades.UsuarioRequest;
import web.jwt.JwtService;
import web.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioRepository urepo;
	
	private JwtService jwtService; // Inyectamos JwtService
    private BCryptPasswordEncoder passwordEncoder;
	@Override
	public List<Usuario> todo() {
		return urepo.findAll();
	}

	@Override
	public List<Usuario> buscarPorSexo(String sexo) {
		return urepo.findBySexo(sexo);
	}

	@Override
	public Usuario buscarPorUsername(String username) {
	    return urepo.findByUsername(username)
	                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
	}

	
	@Override
	public Usuario buscarUno(int idUsuario) {
		return urepo.findById(idUsuario).orElse(null);
	}

	@Override
	public Usuario alta(Usuario usuario) {
		try {
			if (urepo.existsById(usuario.getIdUsuario())) {
				return null;
			}else {
				return urepo.save(usuario);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
			}
	}

	@Override
	public boolean eliminarUsuario(int idUsuario) {
		Optional<Usuario> usuario = urepo.findById(idUsuario);
	    if (usuario.isPresent()) {
	        urepo.delete(usuario.get());
	        return true;
	    }
	    return false;
	}
	public Usuario guardar(Usuario usuario) {
	    // Aquí podrías agregar validaciones adicionales si son necesarias
	    
	    // Guardamos y devolvemos el usuario actualizado
	    return urepo.save(usuario);
	}
	
	 @Override
	    public List<Map<String, Object>> obtenerNuevosUsuariosPorDia() {
	        List<Object[]> resultados = urepo.contarNuevosUsuariosPorDia();

	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	        return resultados.stream().map(obj -> {
	            Map<String, Object> map = new HashMap<>();
	            String fechaFormateada = obj[0].toString();
	            map.put("fecha", fechaFormateada);
	            map.put("cantidad", obj[1]);
	            return map;
	        }).collect(Collectors.toList());
	    }
//	public AuthResponse modificar(Usuario usuarioRequest) {
//	    // Buscar el usuario en la base de datos
//	    Usuario usuarioActual = urepo.findById(usuarioRequest.getIdUsuario())
//	            .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
//
//	    // Actualizar los datos del usuario
//	    usuarioActual.setUsername(usuarioRequest.getUsername());
//	    usuarioActual.setFirstname(usuarioRequest.getFirstname());
//	    usuarioActual.setLastname(usuarioRequest.getLastname());
//	    usuarioActual.setEmail(usuarioRequest.getEmail());
//	    usuarioActual.setDireccion(usuarioRequest.getDireccion());
//	    usuarioActual.setSexo(usuarioRequest.getSexo());
//	    usuarioActual.setTelefono(usuarioRequest.getTelefono());
//
//	    // Si la contraseña ha cambiado, cifrarla antes de guardarla
//	    if (!usuarioRequest.getPassword().equals(usuarioActual.getPassword())) {
//	        usuarioActual.setPassword(passwordEncoder.encode(usuarioRequest.getPassword()));
//	    }
//
//	    // Guardar los cambios en la base de datos
//	    urepo.save(usuarioActual);
//
//	    // Generar un nuevo token con la información actualizada del usuario
//	    String nuevoToken = jwtService.getToken(usuarioActual);
//
//	    // Devolver el nuevo token al frontend
//	    return AuthResponse.builder()
//	            .token(nuevoToken)
//	            .build();
//	}

	





	

	
}
