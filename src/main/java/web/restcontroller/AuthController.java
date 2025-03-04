package web.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import lombok.RequiredArgsConstructor;
import web.auth.AuthResponse;
import web.auth.AuthService;
import web.auth.LoginRequest;
import web.auth.RegisterRequest;
import web.entidades.Usuario;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@CrossOrigin(origins="http://localhost:4200")
public class AuthController {
private final AuthService authService;
    
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request)
    {
        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request)
    {
        return ResponseEntity.ok(authService.register(request));
    }
    
    @PutMapping("/edit")
	public ResponseEntity<AuthResponse> updateUsuario(@RequestBody Usuario usuarioRequest) {
	    System.out.println(usuarioRequest);
	    return ResponseEntity.ok(authService.modificarUsuario(usuarioRequest));
	}
}
