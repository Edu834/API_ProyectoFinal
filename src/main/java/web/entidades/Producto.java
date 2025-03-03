package web.entidades;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name="productos")
public class Producto implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="id_producto")
	private String idProducto;
	private String nombre;
	private String marca;
	private String descripcion;
	private String sexo;
	private float precio;
	
	@ManyToOne
	@JoinColumn(name="id_subcategoria")
	private Subcategoria subcategoria;
	
	@OneToOne
	@JoinColumn(name="id_galeria")
	private Galeria galeria;
}
