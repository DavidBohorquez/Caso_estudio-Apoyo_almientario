package edu.presentacion.controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.persistencia.DBConnection;

/**
 * Servlet implementation class HelloWorldServlet
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DBConnection connection;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TestServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("ENTRÓ GET!!!");

		new DBConnection().conectarDB();
		/*
		 * PrintWriter out = response.getWriter();
		 * out.print("<html><body><h1 align='center'>" + new Date().toString() +
		 * "</h1></body></html>");
		 */
		System.out.println("PASO GET");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("ENTRÓ POST!!!");
		doGet(request, response);
		System.out.println("PASÓ!!!");
		System.out.println("¡¡¡¡¡¡¡¡¡¡" + request.getParameter("username") + "!!!!!!!!!!!!!!!1");
		PrintWriter out = response.getWriter();
		out.print("<html><body><h1 align='center'>" + new Date().toString() + "</h1></body></html>");
	}

}
