package web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import web.entidades.Articulo;

public interface ArticuloRepository extends JpaRepository<Articulo, String>{

}
