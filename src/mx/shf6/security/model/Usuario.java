package mx.shf6.security.model;

import java.sql.Date;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Usuario {
	
	//PROPIEDADES
	private IntegerProperty sysPK;
	private StringProperty usuario;
	private StringProperty contrasena;
	private StringProperty correoElectronico;
	private ObjectProperty<Date> fechaRegistro;
	private ObjectProperty<Date> fechaBloqueo;
	private ObjectProperty<Status> status;
	private ObjectProperty<GrupoUsuario> grupoUsuario;
  
	//CONSTANTES	
	public enum Status {
		BLOQUEADO,
		ACTIVO,
		BAJA;
		
		public String toString() {
			switch (this) {
				case BLOQUEADO:
					return "Bloqueado";
				case ACTIVO:
					return "Activo";
				case BAJA:
					return "Baja";
				default:
					throw new AssertionError("Status desconocido" + this);
			}//FIN SWITCH
		}//FIN METODO
		
	}//FIN ENUM
  
	//CONTRUCTORES
	public Usuario() {
		this(0, "", "", "", new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()), Status.BLOQUEADO, new GrupoUsuario());
	}//FIN CONSTRUCTOR
   
	public Usuario(Integer sysPK, String usuario, String contrasena, String correoElectronico, Date fechaRegistro, Date fechaBloqueo, Status status, GrupoUsuario grupoUsuario) {
		this.sysPK = new SimpleIntegerProperty(sysPK);
		this.usuario = new SimpleStringProperty(usuario);
		this.contrasena = new SimpleStringProperty(contrasena);
		this.correoElectronico = new SimpleStringProperty(correoElectronico);
		this.fechaRegistro = new SimpleObjectProperty<Date>(fechaRegistro);
		this.fechaBloqueo = new SimpleObjectProperty<Date>(fechaBloqueo);
		this.status = new SimpleObjectProperty<Status>(status);
		this.grupoUsuario = new SimpleObjectProperty<GrupoUsuario>(grupoUsuario);
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

	public StringProperty usuarioProperty() {
		return this.usuario;
	}//FIN METODO	

	public String getUsuario() {
		return this.usuarioProperty().get();
	}//FIN METODO	

	public void setUsuario(final String usuario) {
		this.usuarioProperty().set(usuario);
	}//FIN METODO	

	public StringProperty contrasenaProperty() {
		return this.contrasena;
	}//FIN METODO	

	public String getContrasena() {
		return this.contrasenaProperty().get();
	}//FIN METODO	

	public void setContrasena(final String contrasena) {
		this.contrasenaProperty().set(contrasena);
	}//FIN METODO	

	public StringProperty correoElectronicoProperty() {
		return this.correoElectronico;
	}//FIN METODO	

	public String getCorreoElectronico() {
		return this.correoElectronicoProperty().get();
	}//FIN METODO	

	public void setCorreoElectronico(final String correoElectronico) {
		this.correoElectronicoProperty().set(correoElectronico);
	}//FIN METODO	

	public ObjectProperty<Date> fechaRegistroProperty() {
		return this.fechaRegistro;
	}//FIN METODO	

	public Date getFechaRegistro() {
		return this.fechaRegistroProperty().get();
	}//FIN METODO	

	public void setFechaRegistro(final Date fechaRegistro) {
		this.fechaRegistroProperty().set(fechaRegistro);
	}//FIN METODO	

	public ObjectProperty<Date> fechaBloqueoProperty() {
		return this.fechaBloqueo;
	}//FIN METODO	

	public Date getFechaBloqueo() {
		return this.fechaBloqueoProperty().get();
	}//FIN METODO	

	public void setFechaBloqueo(final Date fechaBloqueo) {
		this.fechaBloqueoProperty().set(fechaBloqueo);
	}//FIN METODO	

	public ObjectProperty<Status> statusProperty() {
		return this.status;
	}//FIN METODO	

	public Status getStatus() {
		return this.statusProperty().get();
	}//FIN METODO	

	public void setStatus(final Status status) {
		this.statusProperty().set(status);
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
		
}//FIN CLASE