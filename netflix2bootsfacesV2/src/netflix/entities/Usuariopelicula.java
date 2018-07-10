package netflix.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the usuariopelicula database table.
 * 
 */
@Entity
@NamedQuery(name="Usuariopelicula.findAll", query="SELECT u FROM Usuariopelicula u")
public class Usuariopelicula implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	//bi-directional many-to-one association to Pelicula
	@ManyToOne
	@JoinColumn(name="pelicula")
	private Pelicula peliculaBean;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="usuario")
	private Usuario usuarioBean;

	public Usuariopelicula() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Pelicula getPeliculaBean() {
		return this.peliculaBean;
	}

	public void setPeliculaBean(Pelicula peliculaBean) {
		this.peliculaBean = peliculaBean;
	}

	public Usuario getUsuarioBean() {
		return this.usuarioBean;
	}

	public void setUsuarioBean(Usuario usuarioBean) {
		this.usuarioBean = usuarioBean;
	}

}