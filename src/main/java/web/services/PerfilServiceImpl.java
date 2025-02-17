package web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.entidades.Perfil;
import web.repository.PerfilRepository;

@Service
public class PerfilServiceImpl implements PerfilService{

	@Autowired
	private PerfilRepository perrepo;
	
	@Override
	public List<Perfil> todo() {
		return perrepo.findAll();
	}
	
	@Override
	public Perfil buscarUno(int idPerfil) {
		return perrepo.findById(null).orElse(null);
	}
}
