package netflix.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String usuario;

	private String clave;

	private String email;

	@Temporal(TemporalType.DATE)
	private Date fechanacimiento;

	//bi-directional many-to-one association to Usuariopelicula
	@OneToMany(mappedBy="usuarioBean")
	private List<Usuariopelicula> usuariopeliculas;

	public Usuario() {
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFechanacimiento() {
		return this.fechanacimiento;
	}

	public void setFechanacimiento(Date fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}

	public List<Usuariopelicula> getUsuariopeliculas() {
		return this.usuariopeliculas;
	}

	public void setUsuariopeliculas(List<Usuariopelicula> usuariopeliculas) {
		this.usuariopeliculas = usuariopeliculas;
	}

	public Usuariopelicula addUsuariopelicula(Usuariopelicula usuariopelicula) {
		getUsuariopeliculas().add(usuariopelicula);
		usuariopelicula.setUsuarioBean(this);

		return usuariopelicula;
	}

	public Usuariopelicula removeUsuariopelicula(Usuariopelicula usuariopelicula) {
		getUsuariopeliculas().remove(usuariopelicula);
		usuariopelicula.setUsuarioBean(null);

		return usuariopelicula;
	}

}