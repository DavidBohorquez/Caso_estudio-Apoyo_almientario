package edu.logica;

public class Condicion {
	
	private String descripcion;
	int id, puntaje;
	private Categoria categoria;
	
	public Condicion(Categoria cat) {
		categoria = cat;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId() {
		this.id = id;
	}
	
	public String getDescripcion(){
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion= descripcion;
	}
	
	public int getPuntaje() {
		return puntaje;
	}
	
	public void setPuntaje() {
		this.puntaje = puntaje;
	}
	
	public Categoria getCategoria(){
		return categoria;
	}
	
	public void setCategoria(Categoria categoria) {
		this.categoria= categoria;
	}
	
}
