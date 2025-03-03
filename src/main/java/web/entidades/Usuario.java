package web.entidades;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;



import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name="usuarios", uniqueConstraints = {@UniqueConstraint(columnNames = {"username"})})
public class Usuario implements UserDetails{

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="id_usuario")
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer idUsuario;
	@Basic
	@Column(nullable = false)
	String username;
	@Column(nullable = false)
	String firstname;
	private String lastname;
	private String password;
	private String direccion;
	private String email;
	private String sexo;
	@Column(nullable = false, updatable = false)
	private LocalDateTime fechaAlta;

	private String telefono;
	@Enumerated(EnumType.STRING) 
    Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
      return List.of(new SimpleGrantedAuthority((role.name())));
    }
//	@ManyToMany
//	@JoinTable(
//		name="usuario_con_perfiles"
//		, joinColumns={
//			@JoinColumn(name="id_usuario")
//			}
//		, inverseJoinColumns={
//			@JoinColumn(name="id_perfil")
//			}
//		)
//	private List<Perfil> perfiles;

	
	@Override
    public boolean isAccountNonExpired() {
       return true;
    }
    @Override
    public boolean isAccountNonLocked() {
       return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return true;
    }
}