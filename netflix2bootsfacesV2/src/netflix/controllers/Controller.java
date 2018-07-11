package netflix.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import netflix.dao.*;
import netflix.entities.*;

@ManagedBean
@SessionScoped
public class Controller {
 private Usuario user;
 private Pelicula peli;
 

public Usuario getUser() {
	if(user==null) {
		user=new Usuario();
	}
	return user;
}

public Pelicula getPeli() {
	if(peli==null) {
		peli=new Pelicula();
	}
	return peli;
}
 public String login() {
	 System.out.println("Hola si me llamas");
	 Usuario temp=new UsuarioDao().find(this.user.getUsuario());
	 if(temp!=null) {
		 return "user";
	 }
	 return "login";
 }
 
 public String findPelicula() {
	 Pelicula temp=new PeliculaDao().find(this.peli.getId());
	 Usuario temp2=new UsuarioDao().find(this.user.getUsuario());
	 Usuariopelicula c = new Usuariopelicula();
	 if(this.getBiblioteca()==null) {
		 c.setUsuarioBean(temp2);
		 c.setPeliculaBean(temp);
		 c.setFecha(new Date());
		 c.setId(3);
		 new UsuarioPeliculaDao().insert(c);
		 return "user";
	 }
	return null;
 }
 public List<Pelicula> getPeliculas(){
	return new PeliculaDao().list();
 }
 public List<Integer> getIds(){
	 List<Integer> id=new ArrayList<Integer>(); 
	 Iterator<Pelicula> it = new PeliculaDao().list().iterator(); 
	 while (it.hasNext()) {  
	 id.add(it.next().getId());  
	 }
	 return id;
	 }
 
 public String addPeliculaUsuario() {
	return "user";
	 
 }
 
 public String sigin() {
	 Usuario temp=new UsuarioDao().find(this.user.getUsuario());
	 if(temp==null) {
		 new UsuarioDao().insert(this.user);
		 return "login";
	 }
	return "sig-in";
	 
 }
 public List<Pelicula> getBiblioteca(){
	 List<Usuariopelicula> listaPeliculas= new UsuarioPeliculaDao().list();
	 if(listaPeliculas!=null) {
		 List<Pelicula> lp= new ArrayList<Pelicula>();
		 for(Usuariopelicula temp: listaPeliculas) {
			 if(temp.getUsuarioBean().getUsuario().equals(this.user.getUsuario())) {
				 lp.add(temp.getPeliculaBean());
			 }
		 }
		 return lp;
	 }
	return null;
 }
public String nuevaClave() {
	return null;
	
}
public String olvidarEmail() {
	return null;
	
}
}
