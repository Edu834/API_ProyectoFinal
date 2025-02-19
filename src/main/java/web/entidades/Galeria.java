package web.entidades;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name="galerias")
public class Galeria implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_galeria")
	private int idGaleria;
	
	@Column(name="foto_frontal")
	private String fotoFrontal;
	@Column(name="foto_trasera")
	private String fotoTrasera;
	@Column(name="foto_modelo_frontal")
	private String fotoModeloFrontal;
	@Column(name="foto_modelo_trasera")
	private String fotoModeloTrasera;
	@Column(name="foto_modelo_costado")
	private String fotoModeloCostado;
	@Column(name="foto_modelo_cerca")
	private String fotoModeloCerca;
	
	
}
