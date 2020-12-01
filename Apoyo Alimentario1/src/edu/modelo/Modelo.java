package edu.modelo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.logica.Documento;
import edu.logica.Solicitud;
import edu.persistencia.DAOFactory;
import edu.persistencia.DBConnection;

public class Modelo {

	private DBConnection connDB;
	private DAOFactory factory;
	private ArrayList<Solicitud> solicitudes;
	private ArrayList<String> adList;

	public Modelo() {
		getConnDB();
		getFactory();
	}

	public void addDocs(Solicitud solicitud) throws SQLException {
		solicitudes = (ArrayList<Solicitud>) (List) factory.getSolicitudesDB();
		solicitud.setDocumentos((ArrayList<Documento>) (List) factory.getDocumentosDB().consultarByName(solicitud));
	}

	public void consultarListado() throws SQLException {
		connDB.setConnection(connDB.conectarDBUser("system", "blueplayer10"));

		adList = (ArrayList<String>) (List) getFactory().getSolicitudesDB().consultar1();

		System.out.println(adList.get(0));
		System.out.println(adList.get(1));
		System.out.println(adList.get(2));
	}

	public void establecerConn(String user, String pass) {
		connDB.conectarDBUser(user, pass);
		try {
			solicitudes = (ArrayList<Solicitud>) (List) getFactory().getSolicitudesDB().consultar();

			System.out.println(solicitudes.get(0));
		} catch (SQLException ex) {
			System.out.println(ex);
		}
	}

	public DAOFactory getFactory() {
		if (factory == null) {
			factory = new DAOFactory();
		}
		return factory;
	}

	public DBConnection getConnDB() {
		if (connDB == null) {
			connDB = new DBConnection();
		}
		return connDB;
	}

}
