package web.auth;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CambioPasswordRequest {
	private int idUsuario;
    private String passwordActual;
    private String nuevaPassword;
}