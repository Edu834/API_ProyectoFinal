package web.entidades;


import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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
@Table(name="articulos")
public class Articulo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="id_articulo")
	private String idArticulo;
	private String nombre;
	private String talla;
	private String color;
	private int stock;
	private float precio;
	private String descripcion;
	
	@ManyToOne
	@JoinColumn(name="id_producto")
	private Producto producto;
	
	@ManyToMany
	@JoinTable(
		name="articulos_con_estados"
		, joinColumns={
			@JoinColumn(name="id_articulo")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_estado")
			}
		)
	private List<Estado> estados;
	
	
}
