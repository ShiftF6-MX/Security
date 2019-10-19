package mx.shf6.security.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import mx.shf6.security.model.Rol;
import mx.shf6.utilities.Notificacion;

public class RolDAO {
	
	public static final boolean create(Connection connection, Rol rol) {
		String consulta = "INSERT INTO roles (codigoItem, descripcion) VALUES (?, ?)";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(consulta);
			preparedStatement.setString(1, rol.getCodigoItem());
			preparedStatement.setString(2, rol.getDescripcion());
			preparedStatement.execute();
			return true;
		} catch (SQLException ex) {
			Notificacion.dialogoException(ex);
		}//FIN TRY/CATCH
		return false;
	}//FIN METODO
  
	public static final ArrayList<Rol> read(Connection connection) {
		ArrayList<Rol> arrayListRoles = new ArrayList<Rol>();
		String consulta = "SELECT Sys_PK, CodigoItem, Descripcion FROM roles ORDER BY codigoItem";
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(consulta);
			while (resultSet.next()) {
				Rol claseRol = new Rol();
				claseRol.setSysPK(Integer.valueOf(resultSet.getInt(1)));
				claseRol.setCodigoItem(resultSet.getString(2));
				claseRol.setDescripcion(resultSet.getString(3));
				arrayListRoles.add(claseRol);
			}//FIN WHILE
		} catch (SQLException ex) {
			Notificacion.dialogoException(ex);
		}//FIN TRY/CATCH
		return arrayListRoles;
	}//FIN METODO
  
	public static final boolean update(Connection connection, Rol rol) {
		String consulta = "UPDATE roles SET codigoItem = ?, descripcion = ? WHERE Sys_PK = ?;";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(consulta);
			preparedStatement.setString(1, rol.getCodigoItem());
			preparedStatement.setString(2, rol.getDescripcion());
			preparedStatement.setInt(3, rol.getSysPK());
			preparedStatement.execute();
			return true;
		} catch (SQLException ex) {
			Notificacion.dialogoException(ex);
		}//FIN TRY/CATCH
		return false;
	}//FIN METODO
  
	public static final boolean delete(Connection connection, Rol rol) {
		String consulta = "DELETE FROM roles WHERE Sys_PK = ?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(consulta);
			preparedStatement.setInt(1, rol.getSysPK());
			preparedStatement.execute();
			return true;
		} catch (SQLException ex) {
			Notificacion.dialogoException(ex);
		}//FIN TRY/CATCH
		return false;
	}//FIN METODO
	
}//FIN CLASE