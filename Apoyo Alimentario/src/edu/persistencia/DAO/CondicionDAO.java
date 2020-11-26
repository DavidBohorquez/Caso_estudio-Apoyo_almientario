package edu.persistencia.DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import edu.logica.Condicion;
import edu.persistencia.DBConnection;

public class CondicionDAO extends DBConnection implements DAO{

	private Condicion con;
	@Override
	public void insertar(Object objeto) throws SQLException {
		// TODO Auto-generated method stub
		try {
			String strSQL = "INSERT into Condicion values (?, ?, ?, ?);";
			PreparedStatement st = conectarDB().prepareStatement("");
			st.setInt(1, con.getId());
			st.setString(2, con.getCategoria().getId());
			st.setString(3, con.getDescripcion());
			st.setInt(4, con.getPuntaje());
			
			st.executeUpdate();
			st.close();
			
		
		}catch (SQLException e) {
			String resultado = "No se pudo realizar creacion de la condicion ,"+e.getMessage();
		}
	}

	@Override
	public void modificar(Object objeto) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Object objeto) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Object> consultar() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> consultarByName(Object objeto) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	

}
