package web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import web.entidades.Producto;

public interface ProductoRepository extends JpaRepository<Producto, String>{

}
