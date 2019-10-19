package mx.shf6.security.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import mx.shf6.security.model.GrupoUsuario;
import mx.shf6.utilities.Notificacion;

public class GrupoUsuarioDAO {
	
	public static final boolean create(Connection connection, GrupoUsuario grupoUsuario) {
		String consulta = "INSERT INTO gruposusuario (Nombre, Descripcion) VALUES (?, ?)";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(consulta);
			preparedStatement.setString(1, grupoUsuario.getNombre());
			preparedStatement.setString(2, grupoUsuario.getDescripcion());
			preparedStatement.execute();
			return true;
		} catch (SQLException ex) {
			Notificacion.dialogoException(ex);
		}//FIN TRY/CATCH
		return false;
	}//FIN METODO
  
	public static final ArrayList<GrupoUsuario> read(Connection connection) {
		String consulta = "SELECT Sys_PK, NombreGrupo, Descripcion FROM gruposusuario ORDER BY Nombre ASC";
		ArrayList<GrupoUsuario> arrayListGruposUsuario = new ArrayList<GrupoUsuario>();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(consulta);
			while (resultSet.next()) {
				GrupoUsuario grupoUsuario = new GrupoUsuario();
				grupoUsuario.setSysPK(resultSet.getInt(1));
				grupoUsuario.setNombre(resultSet.getString(2));
				grupoUsuario.setDescripcion(resultSet.getString(3));
				arrayListGruposUsuario.add(grupoUsuario);
			}//FIN WHILE
		} catch (SQLException ex) {
			Notificacion.dialogoException(ex);
		}//FIN TRY/CATCH
		return arrayListGruposUsuario;
	}//FIN METODO
  
	public static final boolean update(Connection connection, GrupoUsuario grupoUsuario) {
		String consulta = "UPDATE gruposusuario SET Nombre = ?, Descripcion = ? WHERE Sys_PK = ?;";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(consulta);
			preparedStatement.setString(1, grupoUsuario.getNombre());
			preparedStatement.setString(2, grupoUsuario.getDescripcion());
			preparedStatement.setInt(3, grupoUsuario.getSysPK());
			preparedStatement.execute();
			return true;
		} catch (SQLException ex) {
			Notificacion.dialogoException(ex);
		}//FIN TRY/CATCH
		return false;
	}//FIN METODO
  
	public static final boolean delete(Connection connection, GrupoUsuario grupoUsuario) {
		String consulta = "DELETE FROM gruposusuario WHERE Sys_PK = ?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(consulta);
			preparedStatement.setInt(1, grupoUsuario.getSysPK());
			preparedStatement.execute();
			return true;
		} catch (SQLException ex) {
			Notificacion.dialogoException(ex);
		}//FIN TRY/CATCH
		return false;
	}//FIN METODO
	
}//FIN CLASE