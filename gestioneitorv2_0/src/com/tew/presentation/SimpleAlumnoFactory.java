package com.tew.presentation;
import javax.faces.context.FacesContext;

public class SimpleAlumnoFactory {	
	
	
	public BeanAlumno createAlumno (FacesContext f) {
		System.out.println("BeanAlumnos - PostConstruct");
		  //Buscamos el alumno en la sesión. Esto es un patrón factoría claramente.
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
