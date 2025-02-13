package web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import web.entidades.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, String>{

}
