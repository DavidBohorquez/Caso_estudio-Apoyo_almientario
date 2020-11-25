package edu.persistencia.DAO;

import java.util.List;
import java.sql.SQLException;

public interface DAO {

	public void insertar(Object objeto) throws SQLException;

	public void modificar(Object objeto) throws SQLException;

	public void eliminar(Object objeto) throws SQLException;

	public List<Object> consultar() throws SQLException;

	public List<Object> consultarByName(Object objeto) throws SQLException;
}
