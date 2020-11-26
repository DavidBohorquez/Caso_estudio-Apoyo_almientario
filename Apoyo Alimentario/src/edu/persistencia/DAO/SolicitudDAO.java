package edu.persistencia.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import edu.logica.Categoria;
import edu.logica.Convocatoria;
import edu.logica.Documento;
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
			PreparedStatement st = conectarDB().prepareStatement("select \r\n" + "    est.k_codigo cod_estudiante,\r\n"
					+ "    est.n_nombre nombre_estudiante,\r\n" + "    sol.k_id id_solicitud,\r\n"
					+ "    sol.f_realizacion fecha_solicitud,\r\n" + "    sol.i_estado estado_solicitud,\r\n"
					+ "    sol.o_observacion observacion_solicitud,\r\n" + "    sop.i_estado estado_documento,\r\n"
					+ "    sop.i_tipo tipo_soporte,\r\n" + "    sop.i_documento documento,\r\n"
					+ "    sop.o_descripcion des_documento,\r\n" + "    sop.q_puntaje puntaje_documento,\r\n"
					+ "    cat.k_id id_categoria,\r\n" + "    cat.o_descripcion des_categoria,\r\n"
					+ "    conv.k_id_convocatoria id_convocatoria,\r\n" + "    conv.q_anio anio_convocatoria, \r\n"
					+ "    conv.q_periodo periodo_convocatoria\r\n" + "from estudiante est\r\n"
					+ "inner join solicitud sol on est.k_codigo = sol.k_id_estudiante\r\n"
					+ "inner join solicitud_soporte sol_sop on sol_sop.id_solicitud = sol.k_id\r\n"
					+ "inner join soporte sop on sop.k_id = sol_sop.id_soporte\r\n"
					+ "inner join categoria cat on cat.k_id = sop.id_categoria\r\n"
					+ "inner join convocatoria conv on conv.k_id_convocatoria = sol.id_convocatoria\r\n"
					+ "where (conv.q_anio, conv.q_periodo) in (select max(q_anio), max(q_periodo) from convocatoria)--solo ultima convocatoria\r\n"
					+ ";");

			ResultSet rs = st.executeQuery();
			ResultSet auxR;
			ResultSet auxR1;

			lista = new ArrayList<Object>();

			Convocatoria conv;
			String auxC;
			Estudiante est;
			String auxE;
			Solicitud solicitud;
			Documento documento;
			Categoria categoria;

			while (rs.next()) {

				conv = new Convocatoria(rs.getString("conv.k_id_convocatoria"));
				conv.setAnio(rs.getInt("conv.q_anio"));
				conv.setPeriodo(rs.getInt("conv.q_periodo"));
				auxC = rs.getString("conv.k_id_convocatoria");

				auxR = rs;
				while (auxC.equals(auxR.getString("conv.k_id_convocatoria"))) {

					est = new Estudiante(auxR.getString("est.k_codigo"));
					est.setNombre(auxR.getString("est.n_nombre"));
					auxE = rs.getString("est.k_codigo");

					solicitud = new Solicitud(auxR.getString("sol.k_id"), conv, est);
					solicitud.setEstado(auxR.getString("sol.i_estado"));
					solicitud.setfRealización(auxR.getDate("sol.f_realizacion"));
					solicitud.setObservacion(auxR.getString("sol.o_observacion"));

					auxR1 = auxR;
					while (auxE.equals(auxR1.getString("est.k_codigo"))) {
						categoria = new Categoria(auxR1.getString("cat.k_id"));
						categoria.setDescripcion(auxR1.getString("cat.o_descripcion"));

						documento = new Documento(auxR1.getString("cat.k_id"), categoria);
						documento.setPuntaje(auxR1.getInt("sop.q_puntaje"));
						documento.setTipo(auxR1.getString("sop.i_tipo"));
						documento.setFile(auxR1.getBlob("sop.i_documento"));
						documento.setDescripcion(auxR1.getString("sop.o_descripcion"));
						auxR1.next();
					}
					auxR.next();
				}
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}
		return null;
	}

	@Override
	public List<Object> consultarByName(Object objeto) throws SQLException {
		Object solicitud;

		return null;
	}
	
	public Solicitud Actualizar(Solicitud sol){
		String respuesta = "";
		DBConnection con = new DBConnection();
    	Connection cn = con.conectarDB(); 
    	PreparedStatement st = null;
        String sentencia = "UPDATE SOLICITUD SET I_ESTADO = 'R', O_OBSERVACION = 'RECHAZADO POR FEO' WERE K_ID = '2';"; 
        System.out.println(sentencia);
        try {	
            st = cn.prepareStatement(sentencia);
            st.setString(1, sol.getEstado());
            st.setString(2, sol.getObservacion());
            st.execute();
            
            respuesta = "Solicitud " + solicitud.getId() + " Actualizada correctamente.";
           
        } catch (SQLException ex) {
            respuesta = "No se pudo cargar la solicitud,"+ex.getMessage();
            JOptionPane.showMessageDialog(null, respuesta);
        }
        return solicitud;
    }

}
