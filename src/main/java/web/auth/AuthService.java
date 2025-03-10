package web.auth;

import java.time.LocalDateTime;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



import lombok.RequiredArgsConstructor;
import web.entidades.Role;
import web.entidades.Usuario;
import web.repository.UsuarioRepository;

@Service
@RequiredArgsConstructor
public class AuthService {
	private final UsuarioRepository userRepository;
    private final web.jwt.JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        UserDetails user=userRepository.findByUsername(request.getUsername()).orElseThrow();
        String token=jwtService.getToken(user);
        return AuthResponse.builder()
            .token(token)
            .build();

    }

    public AuthResponse register(RegisterRequest request) {
        Usuario user = Usuario.builder()
            .username(request.getUsername())
            .password(passwordEncoder.encode( request.getPassword()))
            .firstname(request.getFirstname())
            .lastname(request.lastname)
            .direccion(request.getDireccion())
            .sexo(request.getSexo())
            .email(request.getEmail())
            .telefono(request.getTelefono())
            .fechaAlta(LocalDateTime.now())
            .role(Role.USER)
            .build();

        userRepository.save(user);

        return AuthResponse.builder()
            .token(jwtService.getToken(user))
            .build();
        
    }
    
    public AuthResponse modificarUsuario(Usuario usuarioRequest) {
        Usuario usuarioActual = userRepository.findById(usuarioRequest.getIdUsuario())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        // Actualizamos los datos del usuario sin cambiar la contraseña
        usuarioActual.setUsername(usuarioRequest.getUsername());
        usuarioActual.setFirstname(usuarioRequest.getFirstname());
        usuarioActual.setLastname(usuarioRequest.getLastname());
        usuarioActual.setEmail(usuarioRequest.getEmail());
        usuarioActual.setDireccion(usuarioRequest.getDireccion());
        usuarioActual.setSexo(usuarioRequest.getSexo());
        usuarioActual.setTelefono(usuarioRequest.getTelefono());
        usuarioActual.setFechaNacimiento(usuarioRequest.getFechaNacimiento());
        usuarioActual.setCountry(usuarioRequest.getCountry());
        usuarioActual.setProvince(usuarioRequest.getProvince());
        usuarioActual.setCity(usuarioRequest.getCity());
        usuarioActual.setZipCode(usuarioRequest.getZipCode());

        // Guardamos el usuario actualizado
        userRepository.save(usuarioActual);

        // Generamos un nuevo token JWT
        String nuevoToken = jwtService.getToken(usuarioActual);

        return AuthResponse.builder()
                .token(nuevoToken)
                .build();
    }
    
    public AuthResponse cambiarContrasena(int idUsuario, String passwordActual, String nuevaPassword) {
        // Verificar si las contraseñas son nulas
        if (nuevaPassword == null || passwordActual == null) {
            throw new IllegalArgumentException("La contraseña no puede ser nula.");
        }

        Usuario usuarioActual = userRepository.findById(idUsuario)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        // Verificar que la contraseña actual sea correcta
        if (!passwordEncoder.matches(passwordActual, usuarioActual.getPassword())) {
            throw new RuntimeException("La contraseña actual no es correcta.");
        }

        // Verificar que la nueva contraseña no sea igual a la actual
        if (passwordActual.equals(nuevaPassword)) {
            throw new RuntimeException("La nueva contraseña no puede ser la misma que la actual.");
        }

        // Actualizar la contraseña
        usuarioActual.setPassword(passwordEncoder.encode(nuevaPassword));

        // Guardar el usuario actualizado
        userRepository.save(usuarioActual);

        // Generar un nuevo token para el usuario
        String nuevoToken = jwtService.getToken(usuarioActual);

        return AuthResponse.builder()
                .token(nuevoToken) // Devolver el nuevo token
                .build();
    }

}
