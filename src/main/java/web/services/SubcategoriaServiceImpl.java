package web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.entidades.Subcategoria;
import web.repository.SubcategoriaRepository;

@Service
public class SubcategoriaServiceImpl implements SubcategoriaService{

	@Autowired
	private SubcategoriaRepository srepo;
	
	public List<Subcategoria> todo() {
		return srepo.findAll();
	}

	public List<Subcategoria> buscarPorCategoria(int idCategoria) {
		return srepo.findByCategoria_idCategoria(idCategoria);
	}

	public Subcategoria bucarUno(int idSubcategoria) {
		return srepo.findById(null).orElse(null);
	}

}
