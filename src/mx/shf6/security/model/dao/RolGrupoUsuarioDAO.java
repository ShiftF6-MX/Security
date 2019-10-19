package mx.shf6.security.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import mx.shf6.security.model.GrupoUsuario;
import mx.shf6.security.model.Rol;
import mx.shf6.security.model.RolGrupoUsuario;
import mx.shf6.utilities.Notificacion;

public class RolGrupoUsuarioDAO {
	
	public static final boolean create(Connection connection, RolGrupoUsuario rolGrupoUsuario) {
		String consulta = " INSERT INTO rolgruposusuario (GrupoUsuarioFK, RolFK) values (?, ?)";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(consulta);
			preparedStatement.setInt(1, rolGrupoUsuario.getGrupoUsuario().getSysPK());
			preparedStatement.setInt(2, rolGrupoUsuario.getRol().getSysPK());
			preparedStatement.execute();
			return true;
		} catch (SQLException ex) {
			Notificacion.dialogoException(ex);
		}//FIN TRY/CATCH
		return false;
	}//FIN METODO
  
	public static final ArrayList<RolGrupoUsuario> read(Connection connection) {
		ArrayList<RolGrupoUsuario> arrayListRolGrupoUsuarios = new ArrayList<RolGrupoUsuario>();
		String consulta = "SELECT * FROM inforolgrupousuario";
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(consulta);
			while (resultSet.next()) {
				RolGrupoUsuario rolGrupoUsuario = new RolGrupoUsuario();
				rolGrupoUsuario.setSysPK(resultSet.getInt("RolGrupoUsuarioSysPK"));
				GrupoUsuario grupoUsuario = new GrupoUsuario();
				grupoUsuario.setSysPK(resultSet.getInt("RolGrupoUsuarioGrupoUsuarioSysPK"));
				grupoUsuario.setNombre("RolGrupoUsuarioGrupoUsuarioNombre");
				grupoUsuario.setDescripcion(resultSet.getString("RolGrupoUsuarioGrupoUsuarioDescripcion"));
				rolGrupoUsuario.setGrupoUsuario(grupoUsuario);
				Rol rol = new Rol();
				rol.setSysPK(resultSet.getInt("RolGrupoUsuarioRolSysPK"));
				rol.setCodigoItem(resultSet.getString("RolGrupoUsuarioRolCodigoItem"));
				rol.setDescripcion(resultSet.getString("RolGrupoUsuarioRolDescripcion"));
				rolGrupoUsuario.setRol(rol);
				arrayListRolGrupoUsuarios.add(rolGrupoUsuario);
			}//FIN WHILE
		} catch (SQLException ex) {
			Notificacion.dialogoException(ex);
		}//FIN TRY/CATCH
		return arrayListRolGrupoUsuarios;
	}//FIN METODO
  
	public static ArrayList<RolGrupoUsuario> readPorGrupoUsuario(Connection connection, GrupoUsuario grupoUsuario) {
		ArrayList<RolGrupoUsuario> arrayListRolGrupoUsuarios = new ArrayList<RolGrupoUsuario>();
		String consulta = "SELECT * FROM inforolgrupousuario WHERE RolGrupoUsuarioGrupoUsuarioSysPK = " + grupoUsuario.getSysPK();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(consulta);
			while (resultSet.next()) {
				RolGrupoUsuario rolGrupoUsuario = new RolGrupoUsuario();
				rolGrupoUsuario.setSysPK(resultSet.getInt("RolGrupoUsuarioSysPK"));
				rolGrupoUsuario.setGrupoUsuario(grupoUsuario);
				Rol rol = new Rol();
				rol.setSysPK(resultSet.getInt("RolGrupoUsuarioRolSysPK"));
				rol.setCodigoItem(resultSet.getString("RolGrupoUsuarioRolCodigoItem"));
				rol.setDescripcion(resultSet.getString("RolGrupoUsuarioRolDescripcion"));
				rolGrupoUsuario.setRol(rol);
				arrayListRolGrupoUsuarios.add(rolGrupoUsuario);
			}//FIN WHILE
		} catch (SQLException ex) {
			Notificacion.dialogoException(ex);
		}//FIN TRY/CATCH
		return arrayListRolGrupoUsuarios;
	}//FIN METODO
  
	public boolean update(Connection connection, RolGrupoUsuario rolGrupoUsuario) {
		String consulta = "UPDATE rolgruposusuario SET GrupoUsuarioFK = ?, RolFK = ? WHERE Sys_PK = ?;";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(consulta);
			preparedStatement.setInt(1, rolGrupoUsuario.getGrupoUsuario().getSysPK());
			preparedStatement.setInt(2, rolGrupoUsuario.getRol().getSysPK());
			preparedStatement.setInt(3, rolGrupoUsuario.getSysPK());
			preparedStatement.execute();
			return true;
		} catch (SQLException ex) {
			Notificacion.dialogoException(ex);
		}//FIN TRY/CATCH
		return false;
	}//FIN METODO
  
	public static final boolean delete(Connection connection, RolGrupoUsuario rolGrupoUsuario) {
		String consulta = "DELETE FROM rolgruposusuario WHERE Sys_PK = ?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(consulta);
			preparedStatement.setInt(1, rolGrupoUsuario.getSysPK());
			preparedStatement.execute();
			return true;
		} catch (SQLException ex) {
			Notificacion.dialogoException(ex);
		}//FIN TRY/CATCH
		return false;
	}//FIN METODO
}//FIN CLASE
