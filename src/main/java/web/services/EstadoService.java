package web.services;

import java.util.List;

import web.entidades.Estado;

public interface EstadoService {
	
	List<Estado> todo();
	Estado busacarUno(int idEstado);
	Estado buscarPorNombre(String nombreEstado);
	
}
