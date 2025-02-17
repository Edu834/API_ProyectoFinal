package web.entidades;

import lombok.Data;

@Data
public class ArticuloEnPedidoDTO {
	
	private String idArticulo;
	private String idUsuario;
	private int cantidad;
}
