package web.entidades;

import lombok.Data;

@Data
public class ArticuloEnPedidoDTO {
	
	private String idArticulo;
	private int idUsuario;
	private int cantidad;
	private int diasAlquiler;
}
