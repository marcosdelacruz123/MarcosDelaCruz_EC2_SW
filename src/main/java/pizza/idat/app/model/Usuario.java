package pizza.idat.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="usuario")
public class Usuario {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idusuario;
	private String usuario;
	private String password;
	private String rol;
	
	public Usuario(Integer idusuario, String usuario, String password, String rol) {
		super();
		this.idusuario = idusuario;
		this.usuario = usuario;
		this.password = password;
		this.rol = rol;
	}

	public Usuario() {
		super();
	}

	public Integer getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(Integer idusuario) {
		this.idusuario = idusuario;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}
	
	
	
}
