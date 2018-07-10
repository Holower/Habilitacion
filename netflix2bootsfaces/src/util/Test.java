package util;

import java.util.Date;
import netflix.dao.*;
import netflix.entities.*;


public class Test {
public static void main(String [] args) {
	Usuariopelicula up=new Usuariopelicula();
	up.setUsuarioBean(new UsuarioDao().find("Camilo"));
	up.setPeliculaBean(new PeliculaDao().find(1));
	up.setId(1);
	up.setFecha(new Date());
	new UsuarioPeliculaDao().insert(up);
}
}
