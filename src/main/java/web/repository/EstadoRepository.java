package web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import web.entidades.Estado;


public interface EstadoRepository extends JpaRepository<Estado, Integer>{
	
	public Estado findByNombre(String nombre);
}
