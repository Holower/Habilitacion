package netflix.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import netflix.dao.*;
import netflix.entities.*;

@ManagedBean
@SessionScoped
public class Controller {
 private Usuario user;
 

public Usuario getUser() {
	if(user==null) {
		user=new Usuario();
	}
	return user;
}
 public String login() {
	 System.out.println("Hola si me llamas");
	 Usuario temp=new UsuarioDao().find(this.user.getUsuario());
	 if(temp!=null) {
		 return "user";
	 }
	 return "login";
 }
 public List<Pelicula> getPeliculas(){
	return new PeliculaDao().list();
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
