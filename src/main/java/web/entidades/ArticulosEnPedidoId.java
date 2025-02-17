package web.entidades;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ArticulosEnPedidoId implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
    @Column(name = "id_pedido") 
    private String idPedido;

    @Column(name = "id_articulo")
    private String idArticulo;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArticulosEnPedidoId that = (ArticulosEnPedidoId) o;
        return Objects.equals(idPedido, that.idPedido) && Objects.equals(idArticulo, that.idArticulo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPedido, idArticulo);
    }
}
