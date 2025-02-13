package web.entidades;


import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
	@JoinColumn(name="productos")
	private Producto producto;
	
}
