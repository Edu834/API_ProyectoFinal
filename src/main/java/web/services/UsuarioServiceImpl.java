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
	
<<<<<<< HEAD
=======
	@Override
>>>>>>> d0efdec5beb406f7742b1e94ad3061007a20eb03
	public List<Usuario> todo() {
		return urepo.findAll();
	}

<<<<<<< HEAD
=======
	@Override
>>>>>>> d0efdec5beb406f7742b1e94ad3061007a20eb03
	public List<Usuario> buscarPorSexo(String sexo) {
		return urepo.findBySexo(sexo);
	}

<<<<<<< HEAD
=======
	@Override
>>>>>>> d0efdec5beb406f7742b1e94ad3061007a20eb03
	public Usuario buscarPorUsername(String username) {
		return urepo.findByUsername(username);
	}
	
<<<<<<< HEAD
=======
	@Override
>>>>>>> d0efdec5beb406f7742b1e94ad3061007a20eb03
	public Usuario buscarUno(String idUsuario) {
		return urepo.findById(idUsuario).orElse(null);
	}

<<<<<<< HEAD
=======
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
	
	

>>>>>>> d0efdec5beb406f7742b1e94ad3061007a20eb03
}
