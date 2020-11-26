package edu.presentacion.modelo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.logica.Documento;
import edu.logica.Solicitud;
import edu.persistencia.DAOFactory;

public class Modelo {

	private DAOFactory factory;
	private ArrayList<Solicitud> solicitudes;

	public Modelo() {
		getFactory();
	}

	public void addDocs(Solicitud solicitud) throws SQLException {
		solicitudes = (ArrayList<Solicitud>) (List) factory.getSolicitudesDB();
		solicitud.setDocumentos((ArrayList<Documento>) (List) factory.getDocumentosDB().consultarByName(solicitud));
	}

	public DAOFactory getFactory() {
		if (factory == null) {
			factory = new DAOFactory();
		}
		return factory;
	}

}
