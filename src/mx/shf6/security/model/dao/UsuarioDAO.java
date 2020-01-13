package mx.shf6.security.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import mx.shf6.security.model.GrupoUsuario;
import mx.shf6.security.model.Usuario;
import mx.shf6.utilities.Notificacion;

public class UsuarioDAO {
	
	//CONSTANTES
	public static final int NO_REGISTRADO = 0;
	public static final int CONTRASENA_INCORRECTA = 1;
	public static final int USUARIO_BLOQUEADO = 2;
	public static final int ACCESO_CORRECTO = 3;
  
	public static final boolean create(Connection connection, Usuario usuario) {
		String consulta = " INSERT INTO usuarios (Usuario, Contrasena, CorreoElectronico, FechaRegistro, FechaBloqueo, Status, GrupoUsuarioFK) VALUES ( ?, aes_encrypt(?, 'ShiftF6'), ?, ?, ?, ?, ?)";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(consulta);
			preparedStatement.setString(1, usuario.getUsuario());
			preparedStatement.setString(2, usuario.getContrasena());
			preparedStatement.setDate(4, usuario.getFechaRegistro());
			preparedStatement.setDate(5, usuario.getFechaBloqueo());
			preparedStatement.setInt(5, usuario.getStatus().getConstante());
			preparedStatement.setInt(6, usuario.getGrupoUsuario().getSysPK());
			preparedStatement.execute();
			return true;
		} catch (SQLException ex) {
			Notificacion.dialogoException(ex);
		}//FIN TRY/CATCH
		return false;
	}//FIN METODO
  
	public static final ArrayList<Usuario> read(Connection connection) {
		ArrayList<Usuario> arrayListUsuarios = new ArrayList<Usuario>();
		String consulta = "SELECT * FROM infousuarios ORDER BY UsuarioNombre ASC";
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(consulta);
			while (resultSet.next()) {
				Usuario usuario = new Usuario();
				usuario.setSysPK(resultSet.getInt("UsuarioSysPK"));
				usuario.setUsuario(resultSet.getString("UsuarioNombre"));
				usuario.setContrasena(resultSet.getString("UsuarioContrasena"));
				usuario.setFechaRegistro(resultSet.getDate("UsuarioFechaRegistro"));
				usuario.setFechaBloqueo(resultSet.getDate("UsuarioFechaBloqueo"));
				usuario.setStatus(Usuario.Status.valueOf(resultSet.getInt("UsuarioStatus")));
				GrupoUsuario grupoUsuario = new GrupoUsuario();
				grupoUsuario.setSysPK(resultSet.getInt("UsuarioGrupoUsuarioSysPK"));
				grupoUsuario.setNombre(resultSet.getString("UsuarioGrupoUsuarioNombre"));
				grupoUsuario.setDescripcion(resultSet.getString("UsuarioGrupoUsuarioDescripcion"));
				usuario.setGrupoUsuario(grupoUsuario);
				arrayListUsuarios.add(usuario);
			}//FIN WHILE
		} catch (SQLException ex) {
			Notificacion.dialogoException(ex);
		}//FIN TRY/CATCH
		return arrayListUsuarios;
	}//FIN METODO
  
	public static final boolean update(Connection connection, Usuario usuario) {
  		String consulta = "UPDATE usuarios SET Usuario = ?, Contrasena = aes_encrypt(?, 'ShiftF6'), FechaRegistro = ?, FechaBloqueo = ?, Status = ?, GrupoUsuarioFK = ? WHERE Sys_PK = ?";
  		try {
  			PreparedStatement preparedStatement = connection.prepareStatement(consulta);
  			preparedStatement.setString(1, usuario.getUsuario());
  			preparedStatement.setString(2, usuario.getContrasena());
  			preparedStatement.setDate(3, usuario.getFechaRegistro());
  			preparedStatement.setDate(4, usuario.getFechaBloqueo());
  			preparedStatement.setInt(5, usuario.getStatus().getConstante());
  			preparedStatement.setInt(6, usuario.getGrupoUsuario().getSysPK());
  			preparedStatement.setInt(7, usuario.getSysPK());
  			preparedStatement.execute();
  			return true;
  		} catch (SQLException ex) {
  			Notificacion.dialogoException(ex);
  		}//FIN TRY/CATCH
  		return false;
  	}//FIN METODO
  
  	public static final boolean delete(Connection connection, Usuario usuario) {
  		String consulta = "DELETE FROM usuarios WHERE Sys_PK = ?";
  		try {
  			PreparedStatement preparedStatement = connection.prepareStatement(consulta);
  			preparedStatement.setInt(1, usuario.getSysPK());
  			preparedStatement.execute();
  			return true;
  		} catch (SQLException ex) {
  			Notificacion.dialogoException(ex);
  		}//FIN TRY/CATCH
  		return false;
  	}//FIN METODO
  
}//FIN CLASE