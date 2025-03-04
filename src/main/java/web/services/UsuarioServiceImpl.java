package web.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.entidades.Usuario;
import web.entidades.UsuarioDTO;
import web.entidades.UsuarioRequest;
import web.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioRepository urepo;
	
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

	public Usuario modificar(Usuario usuario) {
        try {
            Optional<Usuario> usuarioExistente = urepo.findById(usuario.getIdUsuario());
            if (usuarioExistente.isPresent()) {
                Usuario usuarioActual = usuarioExistente.get();
                usuarioActual.setUsername(usuario.getUsername());
                usuarioActual.setFirstname(usuario.getFirstname());
                usuarioActual.setLastname(usuario.getLastname());
                usuarioActual.setPassword(usuario.getPassword());
                usuarioActual.setEmail(usuario.getEmail());
                usuarioActual.setDireccion(usuario.getDireccion());
                usuarioActual.setSexo(usuario.getSexo());
                usuarioActual.setTelefono(usuario.getTelefono());
                usuarioActual.setRole((usuario.getRole()));
                return urepo.save(usuarioActual);
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

	

	
}
