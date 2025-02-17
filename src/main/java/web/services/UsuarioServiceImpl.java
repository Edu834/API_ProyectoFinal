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
	
	public List<Usuario> todo() {
		return urepo.findAll();
	}

	public List<Usuario> buscarPorSexo(String sexo) {
		return urepo.findBySexo(sexo);
	}

	public Usuario buscarPorUsername(String username) {
		return urepo.findByUsername(username);
	}
	
	public Usuario buscarUno(String idUsuario) {
		return urepo.findById(idUsuario).orElse(null);
	}

}
