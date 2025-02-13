package web.entidades;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
	
    @ManyToOne
    @JoinColumn(name = "pedidos", referencedColumnName = "id_pedido")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "articulo", referencedColumnName = "id_articulo")
    private Articulo articulo;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArticulosEnPedidoId that = (ArticulosEnPedidoId) o;
        return Objects.equals(pedido, that.pedido) && Objects.equals(articulo, that.articulo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pedido, articulo);
    }
}
