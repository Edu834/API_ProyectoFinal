package web.services;

import java.util.List;

import web.entidades.Perfil;

public interface PerfilService {

	List<Perfil> todo();
	Perfil buscarUno(int idPerfil);
}
