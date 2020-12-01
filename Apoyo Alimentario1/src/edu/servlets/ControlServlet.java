package edu.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.modelo.Modelo;

/**
 * Servlet implementation class ControlServlet
 */
@WebServlet("/ControlServlet")
public class ControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Modelo modelo;

	/**
	 * Default constructor.
	 */
	public ControlServlet() {
		super();
		getModelo();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("ENTRO!!!!!!!!!!!!!!");

		// response.getWriter().append("Served at: ").append(request.getContextPath());

		try {
			modelo.consultarListado();
		} catch (SQLException e) {

			System.err.println(e);
		}

		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("PASO POST!!!!!!!!!!!!!!");

		request.getRequestDispatcher("index.html").forward(request, response);
		//response.sendRedirect("index.html");

		// doGet(request, response);

	}

	public Modelo getModelo() {
		if (modelo == null) {
			modelo = new Modelo();
		}
		return modelo;
	}

}
