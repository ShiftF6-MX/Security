package mx.shf6.security.model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Rol {
	
	//PROPIEDADES
	private IntegerProperty sysPk;
	private StringProperty codigoItem;
	private StringProperty descripcion;
	private BooleanProperty seleccionado;
  
	//CONSTRUCTORES
	public Rol() {
		this(0, "", "", false);
	}//FIN CONSTRUCTOR
  
	public Rol(Integer sysPk, String codigoItem, String descripcion, boolean seleccionado) {
		this.sysPk = new SimpleIntegerProperty(sysPk);
		this.codigoItem = new SimpleStringProperty(codigoItem);
		this.descripcion = new SimpleStringProperty(descripcion);
		this.seleccionado = new SimpleBooleanProperty(seleccionado);
	}//FIN CONSTRUCTOR

	//METODOS
	public IntegerProperty sysPkProperty() {
		return this.sysPk;
	}//FIN METODO	

	public int getSysPk() {
		return this.sysPkProperty().get();
	}//FIN METODO	

	public void setSysPk(final int sysPk) {
		this.sysPkProperty().set(sysPk);
	}//FIN METODO	

	public StringProperty codigoItemProperty() {
		return this.codigoItem;
	}//FIN METODO	

	public String getCodigoItem() {
		return this.codigoItemProperty().get();
	}//FIN METODO	

	public void setCodigoItem(final String codigoItem) {
		this.codigoItemProperty().set(codigoItem);
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

	public BooleanProperty seleccionadoProperty() {
		return this.seleccionado;
	}//FIN METODO	

	public boolean isSeleccionado() {
		return this.seleccionadoProperty().get();
	}//FIN METODO	

	public void setSeleccionado(final boolean seleccionado) {
		this.seleccionadoProperty().set(seleccionado);
	}//FIN METODO	
  	
}//FIN CLASE