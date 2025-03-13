package web.entidades;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name="articulos_en_pedidos")
public class ArticulosEnPedido implements Serializable{

	private static final long serialVersionUID = 1L;

	@EmbeddedId
    private ArticulosEnPedidoId id;

    private int cantidad;

    @Column(name = "cantidad_devuelta")
    private int cantidadDevuelta;

    private String estado;
    
    @Column(name = "dias_alquiler")
    private int diasAlquiler;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_devuelta")
    private Date fechaDevuelta;
    
//    @ManyToOne
//    @JoinColumn(name="id_articulo")
//    private Articulo articulo;
//    
//    @ManyToOne
//    @JoinColumn(name="id_pedido")
//    private Pedido pedido;
    
}
