package edu.logica;

import java.sql.Date;
import java.util.ArrayList;

public class Solicitud {
	private String id, estado, observacion;
	Date fRealización;
	private Convocatoria convocatoria;
	private Estudiante solicitante;
	private ArrayList<Documento> documentos;

	public Solicitud(String id, Convocatoria conv, Estudiante est) {
		this.id = id;
		convocatoria = conv;
		solicitante = est;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Date getfRealización() {
		return fRealización;
	}

	public void setfRealización(Date fRealización) {
		this.fRealización = fRealización;
	}

	public Convocatoria getConvocatoria() {
		return convocatoria;
	}

	public void setConvocatoria(Convocatoria convocatoria) {
		this.convocatoria = convocatoria;
	}

	public Estudiante getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(Estudiante solicitante) {
		this.solicitante = solicitante;
	}

	public ArrayList<Documento> getDocumentos() {
		return documentos;
	}

	public void setDocumentos(ArrayList<Documento> documentos) {
		this.documentos = documentos;
	}

}
