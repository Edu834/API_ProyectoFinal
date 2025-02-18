package web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.entidades.Usuario;
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
		return urepo.findByUsername(username);
	}
	
	@Override
	public Usuario buscarUno(String idUsuario) {
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
	public Usuario modificar(Usuario usuario) {
		try {
			if (urepo.existsById(usuario.getIdUsuario())) {
				return urepo.save(usuario);
			}else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
			}
	}
}
