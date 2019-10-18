package mx.shf6.security.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

public class RolGrupoUsuario {
	
	//PROPIEDADES
	private IntegerProperty sysPK;
	private ObjectProperty<GrupoUsuario> grupoUsuario;
	private ObjectProperty<Rol> rol;
  
	//CONSTRUCTORES
	public RolGrupoUsuario() {
		this(0, new GrupoUsuario(), new Rol());
	}//FIN CONSTRUCTOR
  
	public RolGrupoUsuario(Integer sysPK, GrupoUsuario grupoUsuario, Rol rol) {
		this.sysPK = new SimpleIntegerProperty(sysPK);
		this.grupoUsuario = new SimpleObjectProperty<GrupoUsuario>(grupoUsuario);
		this.rol = new SimpleObjectProperty<Rol>(rol);
	}//FIN CONSTRUCTOR

	public IntegerProperty sysPKProperty() {
		return this.sysPK;
	}//FIN METODO	

	public int getSysPK() {
		return this.sysPKProperty().get();
	}//FIN METODO	

	public void setSysPK(final int sysPK) {
		this.sysPKProperty().set(sysPK);
	}//FIN METODO	

	public ObjectProperty<GrupoUsuario> grupoUsuarioProperty() {
		return this.grupoUsuario;
	}//FIN METODO	

	public GrupoUsuario getGrupoUsuario() {
		return this.grupoUsuarioProperty().get();
	}//FIN METODO	

	public void setGrupoUsuario(final GrupoUsuario grupoUsuario) {
		this.grupoUsuarioProperty().set(grupoUsuario);
	}//FIN METODO	

	public ObjectProperty<Rol> rolProperty() {
		return this.rol;
	}//FIN METODO	

	public Rol getRol() {
		return this.rolProperty().get();
	}//FIN METODO	

	public void setRol(final Rol rol) {
		this.rolProperty().set(rol);
	}//FIN METODO	
	
}//FIN CLASE