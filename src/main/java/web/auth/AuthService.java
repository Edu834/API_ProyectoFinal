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

        usuarioActual.setUsername(usuarioRequest.getUsername());
        usuarioActual.setFirstname(usuarioRequest.getFirstname());
        usuarioActual.setLastname(usuarioRequest.getLastname());
        usuarioActual.setEmail(usuarioRequest.getEmail());
        usuarioActual.setDireccion(usuarioRequest.getDireccion());
        usuarioActual.setSexo(usuarioRequest.getSexo());
        usuarioActual.setTelefono(usuarioRequest.getTelefono());

        // 🔹 Si la contraseña cambió, la ciframos antes de guardarla
        if (!usuarioRequest.getPassword().equals(usuarioActual.getPassword())) {
            usuarioActual.setPassword(passwordEncoder.encode(usuarioRequest.getPassword())); // ✅ Ya no es null
        }

        userRepository.save(usuarioActual);

        String nuevoToken = jwtService.getToken(usuarioActual);

        return AuthResponse.builder()
                .token(nuevoToken)
                .build();
    }
}
