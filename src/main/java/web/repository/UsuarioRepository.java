package web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import web.entidades.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, String>{

}
