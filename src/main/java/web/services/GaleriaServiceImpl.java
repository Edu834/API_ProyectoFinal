package web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.entidades.Galeria;
import web.repository.GaleriaRepository;

@Service
public class GaleriaServiceImpl implements GaleriaService{

	@Autowired
	private GaleriaRepository grepo;
	
	@Override
	public List<Galeria> todo() {
		return grepo.findAll();
	}

	@Override
	public Galeria buscarUno(int idGaleria) {
		return grepo.findById(idGaleria).orElse(null);
	}
}
