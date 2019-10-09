package com.tew.presentation;
import java.io.Serializable;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
@ManagedBean
@SessionScoped
public class BeanSettings implements Serializable{
	private static final long serialVersionUID = 2L;
	private static final Locale ENGLISH = new Locale("en");
	private static final Locale SPANISH = new Locale("es");
	private Locale locale = new Locale("es");
	
	public Locale getLocale() { /*Habria que cambiar algo de código para coger locale del navegador la primera vez que se accede a getLocale(), de momento el idioma departida “es”*/
		return(locale);
	}
	public void setSpanish(ActionEvent event) {
		locale = SPANISH;
		 try {
			 FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
			 if (alumno != null)
				 if (alumno.getId()== null) //valores por defecto del alumno, si no NO inicializar
					 alumno.iniciaAlumno(null);
			 } catch (Exception ex){
			 ex.printStackTrace();
			 }
					 
	}
	public void setEnglish(ActionEvent event) {
		locale = ENGLISH;
		 try {
			 FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
			 if (alumno != null)
				 if (alumno.getId()== null) //valores por defecto del alumno, si no NO inicializar
					 alumno.iniciaAlumno(null);
			 } catch (Exception ex){
			 ex.printStackTrace();
			 }
	}
	
	@ManagedProperty(value="#{alumno}")
	private BeanAlumno alumno;
	public BeanAlumno getAlumno() { return alumno; }
	public void setAlumno(BeanAlumno alumno) {this.alumno = alumno;}
	
	@PostConstruct
	public void init() {
		 System.out.println("BeanAlumnos - PostConstruct");
		  FacesContext f= FacesContext.getCurrentInstance();
		  alumno= new SimpleAlumnoFactory().createAlumno(f);	
	}
	
	//Es sólo a modo de traza.
	@PreDestroy
	public void end()
	{
	 System.out.println("BeanSettings - PreDestroy");
	}
}

