package mx.shf6.security.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class GrupoUsuario {
	
	//PROPIEDADES
	private IntegerProperty sysPK;
	private StringProperty nombre;
	private StringProperty descripcion;
  
	//COSNTRUCTORES
	public GrupoUsuario() {
		this(0, "", "");
	}//FIN CONSTRUCTOR
  
	public GrupoUsuario(Integer sysPK, String nombre, String descripcion) {
		this.sysPK = new SimpleIntegerProperty(sysPK);
		this.nombre = new SimpleStringProperty(nombre);
		this.descripcion = new SimpleStringProperty(descripcion);
	}//FIN CONSTRUCTOR

	//METODOS
	public IntegerProperty sysPKProperty() {
		return this.sysPK;
	}//FIN METODO	

	public int getSysPK() {
		return this.sysPKProperty().get();
	}//FIN METODO	

	public void setSysPK(final int sysPK) {
		this.sysPKProperty().set(sysPK);
	}//FIN METODO	

	public StringProperty nombreProperty() {
		return this.nombre;
	}//FIN METODO	

	public String getNombre() {
		return this.nombreProperty().get();
	}//FIN METODO	

	public void setNombre(final String nombre) {
		this.nombreProperty().set(nombre);
	}//FIN METODO	

	public StringProperty descripcionProperty() {
		return this.descripcion;
	}//FIN METODO	

	public String getDescripcion() {
		return this.descripcionProperty().get();
	}//FIN METODO	

	public void setDescripcion(final String descripcion) {
		this.descripcionProperty().set(descripcion);
	}//FIN METODO
	
	@Override
	public String toString() {
		return this.getNombre();
	}//FIN METODO
		
}//FIN CLASE