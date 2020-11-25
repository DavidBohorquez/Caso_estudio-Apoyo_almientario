package edu.persistencia.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import edu.logica.Convocatoria;
import edu.logica.Estudiante;
import edu.logica.Solicitud;
import edu.persistencia.DBConnection;

public class SolicitudDAO extends DBConnection implements DAO {

	@Override
	public void insertar(Object objeto) throws SQLException {
		// TODO Auto-generated method stub

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
		List<Object> lista = null;

		try {
			PreparedStatement st = conectarDB().prepareStatement("");

			ResultSet rs = st.executeQuery();

			lista = new ArrayList<Object>();

			while (rs.next()) {
				Solicitud solicitud = new Solicitud(rs.getString("K_ID"),new Convocatoria(rs.getString("K_ID_CONVOCATORIA")),
						new Estudiante(rs.getString("K_ID_ESTUDIANTE")));
				
				solicitud.setEstado(rs.getString("I_ESTADO"));
				solicitud.setfRealización(rs.getDate("F_REALIZACION"));
				solicitud.setObservacion(rs.getString("O_OBSERVACION"));
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}
		return null;
	}

	@Override
	public List<Object> consultarByName(Object objeto) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
