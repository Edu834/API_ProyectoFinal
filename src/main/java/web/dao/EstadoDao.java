package web.dao;

import java.util.List;

import web.entidades.Estado;

public interface EstadoDao {
	
	List<Estado> todo();
	Estado busacarUno(int idEstado);
	Estado buscarPorNombre(String nombreEstado);
	
}
