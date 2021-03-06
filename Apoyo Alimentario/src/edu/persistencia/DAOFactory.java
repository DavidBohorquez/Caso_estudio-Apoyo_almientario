package edu.persistencia;

import edu.persistencia.DAO.DocumentoDAO;
import edu.persistencia.DAO.SolicitudDAO;

public class DAOFactory {

	private SolicitudDAO solicitudesDB;
	private DocumentoDAO documentosDB;
	private CondicionDAO condicionDB;

	public DAOFactory() {

	}

	public SolicitudDAO getSolicitudesDB() {
		if (solicitudesDB == null) {
			solicitudesDB = new SolicitudDAO();
		}
		return solicitudesDB;
	}

	public DocumentoDAO getDocumentosDB() {
		if (documentosDB == null) {
			documentosDB = new DocumentoDAO();
		}
		return documentosDB;
	}
	
	public CondicionDAO getCondicionDB() {
		if (condicionDB == null) {
			condicionDB = new CondicionDAO();
		}
		return condicionDB;
	}

}
