package web.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@Table(name="pedidos")
public class Pedido implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="id_pedido")
	private String idPedido;
	
	private String descripcion;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fecha")
	private Date fecha;
	
	private String estado;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_entrega")
	private String fechaEntrega;
	
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario;
	
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
	@JoinColumns({
	    @JoinColumn(name = "id_pedido", referencedColumnName = "id_pedido")
	})
	private List<ArticulosEnPedido> articulosEnPedido;
	
	public void addArticulo(ArticulosEnPedido articulo) {
		
		int pos = articulosEnPedido.indexOf(articulo);
		
		if (pos != -1) {
			articulosEnPedido.get(pos).setCantidad(articulosEnPedido.get(pos).getCantidad() + articulo.getCantidad());
		}else {
			articulosEnPedido.add(articulo);
		}
	}
	
	
	
	
}
