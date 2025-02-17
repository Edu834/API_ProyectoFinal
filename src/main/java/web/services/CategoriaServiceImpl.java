package web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.entidades.Categoria;
import web.repository.CategoriaRepository;

@Service
public class CategoriaServiceImpl implements CategoriaService{

	@Autowired
	private CategoriaRepository crepo;
	
	@Override
	public List<Categoria> todo() {
		return crepo.findAll();
	}
	
	@Override
	public Categoria buscarUno(int idCategoria) {
		return crepo.findById(idCategoria).orElse(null);
	}

}
