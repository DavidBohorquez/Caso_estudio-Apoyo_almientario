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

public class SolicitudDAO /* extends DBConnection */ implements DAO {

	@Override
	public void insertar(Object objeto) throws SQLException {
		try {
			String strSQL = "INSERT into Solicitud values (?, CURRENT_DATE, 'E', '', ?, ?);";
			PreparedStatement st = DBConnection.connection.prepareStatement("");
			st.setString(1, ((Solicitud) objeto).getId());
			st.setString(2, ((Solicitud) objeto).getConvocatoria().getId());
			st.setString(3, ((Solicitud) objeto).getSolicitante().getCodigo());

			st.executeUpdate();
			st.close();

		} catch (SQLException e) {
			String resultado = "No se pudo realizar la solicitud," + e.getMessage();
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
		List<Object> lista = null;

		System.out.println("DAO1");

		try {
			PreparedStatement st = DBConnection.connection.prepareStatement("select \r\n"
					+ "    est.k_codigo cod_estudiante,\r\n" + "    est.n_nombre nombre_estudiante,\r\n"
					+ "    sol.k_id id_solicitud,\r\n" + "    sol.f_realizacion fecha_solicitud,\r\n"
					+ "    sol.i_estado estado_solicitud,\r\n" + "    sol.o_observacion observacion_solicitud,\r\n"
					+ "    sop.i_estado estado_documento,\r\n" + "    sop.i_tipo tipo_soporte,\r\n"
					+ "    sop.i_documento documento,\r\n" + "    sop.o_descripcion des_documento,\r\n"
					+ "    sop.q_puntaje puntaje_documento,\r\n" + "    cat.k_id id_categoria,\r\n"
					+ "    cat.o_descripcion des_categoria,\r\n" + "    conv.k_id_convocatoria id_convocatoria,\r\n"
					+ "    conv.q_anio anio_convocatoria, \r\n" + "    conv.q_periodo periodo_convocatoria\r\n"
					+ "from estudiante est\r\n" + "inner join solicitud sol on est.k_codigo = sol.k_id_estudiante\r\n"
					+ "inner join solicitud_soporte sol_sop on sol_sop.id_solicitud = sol.k_id\r\n"
					+ "inner join soporte sop on sop.k_id = sol_sop.id_soporte\r\n"
					+ "inner join categoria cat on cat.k_id = sop.id_categoria\r\n"
					+ "inner join convocatoria conv on conv.k_id_convocatoria = sol.id_convocatoria\r\n"
					+ "where (conv.q_anio, conv.q_periodo) in (select max(q_anio), max(q_periodo) from convocatoria)--solo ultima convocatoria");

			System.out.println("DAO22222");

			ResultSet rs = st.executeQuery();
			System.out.println("da3333333333");
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
			System.out.println("11111111111111");
			while (rs.next()) {
				System.out.println("222222222222222");
				conv = new Convocatoria(rs.getString("conv.k_id_convocatoria"));
				conv.setAnio(rs.getInt("conv.q_anio"));
				conv.setPeriodo(rs.getInt("conv.q_periodo"));
				auxC = rs.getString("conv.k_id_convocatoria");

				auxR = rs;
				while (auxC.equals(auxR.getString("conv.k_id_convocatoria"))) {
					System.out.println("33333333333333");
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
						System.out.println("DAO1");
					}
					auxR.next();
					lista.add(solicitud);
				}
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}

		DBConnection.connection.close();
		return lista;
	}

	public List<Object> consultar1() throws SQLException {
		List<Object> lista = null;

		try {
			PreparedStatement st = DBConnection.connection
					.prepareStatement("select est.k_codigo, est.n_nombre, sub.i_tipo\r\n" + "from estudiante est\r\n"
							+ "inner join solicitud sol on est.k_codigo = sol.k_id_estudiante\r\n"
							+ "inner join beneficio ben on sol.k_id = ben.id_solicitud\r\n"
							+ "inner join tipo_subsidio tip_sub on ben.id_tipo_subsidio = tip_sub.k_id\r\n"
							+ "inner join subsidio sub on tip_sub.id_subsidio = sub.k_id\r\n"
							+ "inner join convocatoria conv on conv.k_id_convocatoria = sol.id_convocatoria\r\n"
							+ "where (conv.q_anio, conv.q_periodo) in (select max(q_anio), max(q_periodo) from convocatoria)");

			System.out.println("RESULTSET!!!!");
			ResultSet rs = st.executeQuery();
			System.out.println("PASÓ RESULTSET!!!!");

			ResultSet auxR;
			ResultSet auxR1;

			lista = new ArrayList<Object>();

			while (rs.next()) {
				lista.add(rs.getString("k_codigo"));
				lista.add(rs.getString("n_nombre"));
				lista.add(rs.getString("i_tipo"));
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}

		DBConnection.connection.close();
		return lista;
	}

	@Override
	public List<Object> consultarByName(Object objeto) throws SQLException {
		Object solicitud;

		return null;
	}

	public void Actualizar(Solicitud sol) {
		String respuesta = "";
		PreparedStatement st = null;
		String sentencia = "UPDATE SOLICITUD SET I_ESTADO = 'R', O_OBSERVACION = 'RECHAZADO POR FEO' WERE K_ID = '2';";

		try {
			// st = conectarDB().prepareStatement(sentencia);
			st.setString(1, sol.getEstado());
			st.setString(2, sol.getObservacion());
			st.execute();

			// respuesta = "Solicitud " + solicitud.getId() + " Actualizada correctamente.";

		} catch (SQLException ex) {
			respuesta = "No se pudo cargar la solicitud," + ex.getMessage();
			JOptionPane.showMessageDialog(null, respuesta);
		}

	}

}
