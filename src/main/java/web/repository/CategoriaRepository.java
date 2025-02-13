package web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import web.entidades.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{

}
