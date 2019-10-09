package com.tew.presentation;
import javax.faces.context.FacesContext;

public class SimpleAlumnoFactory {	
	
	
	public BeanAlumno createAlumno (FacesContext f) {
		System.out.println("BeanAlumnos - PostConstruct");
		  //Buscamos el alumno en la sesi�n. Esto es un patr�n factor�a claramente.
		  BeanAlumno alumno = (BeanAlumno)
				  f.getExternalContext().getSessionMap().get(new
						  String("alumno"));
		  //si no existe lo creamos e inicializamos
		  if (alumno == null) {
			  System.out.println("BeanAlumnos - No existia");
			  alumno = new BeanAlumno();
			  f.getExternalContext().getSessionMap().put( "alumno",
					  alumno);
		  }
		  return alumno;
		
		
		
	}
	
	
	
	
	

}
