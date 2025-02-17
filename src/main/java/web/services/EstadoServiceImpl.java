package web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.entidades.Estado;
import web.repository.EstadoRepository;

@Service
public class EstadoServiceImpl implements EstadoService{
	
	@Autowired
	private EstadoRepository erepo;
	
	@Override
	public List<Estado> todo() {
		return erepo.findAll();
	}
	
	@Override
	public Estado buscarPorNombre(String nombreEstado) {
		return erepo.findByNombre(nombreEstado);
	}
	
	@Override
	public Estado busacarUno(int idEstado) {
		return erepo.findById(idEstado).orElse(null);
	}

}
