package web.services;

import java.util.List;

import web.entidades.Galeria;

public interface GaleriaService {
	
	List<Galeria> todo();
	Galeria buscarUno(int idGaleria);
}
