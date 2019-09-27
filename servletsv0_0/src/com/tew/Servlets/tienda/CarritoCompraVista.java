package com.tew.Servlets.tienda;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CarritoCompraVista
 */
@WebServlet(name = "CarritoCompraVista", urlPatterns = { "/CarritoCompraVista" }) 
public class CarritoCompraVista extends HttpServlet {
	private static final long serialVersionUID = 2L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarritoCompraVista() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		
		HashMap<String,Integer> carrito = (HashMap<String,Integer>)request.getSession().getAttribute("carrito");
		
		PrintWriter out = response.getWriter();
		out.println("<HTML>");
		out.println("<HEAD><TITLE>CarritoDeLaCompra</TITLE></HEAD>");
		out.println("<BODY>");
		
		out.println("<FORM>");
		out.println("<h1>Objetos de la tienda <h1/>");
		out.println("<SELECT NAME=\"producto\" SIZE=\"1\">");
		out.println("<OPTION VALUE=\"010\">Ordenador</OPTION>");
		out.println("<OPTION VALUE=\"345\">Gafas</OPTION>");
		out.println("<OPTION VALUE=\"554\">Pantalones</OPTION>");
		out.println("<OPTION VALUE=\"210\">Silla</OPTION>");
		out.println("<OPTION VALUE=\"023\">Mesa</OPTION>");
		out.println("<OPTION VALUE=\"342\">Estuche</OPTION>");
		out.println("<OPTION VALUE=\"655\">Bolso</OPTION>");
		out.println("<OPTION VALUE=\"634\">Zapatillas</OPTION>");
		out.println("<OPTION VALUE=\"976\">Gorra</OPTION>");
		out.println("<OPTION VALUE=\"482\">Camiseta</OPTION>");
		out.println("</SELECT>");
		
		out.println("<input type=\"submit\" value=\"submit\">");
		out.println("</FORM>");
		
		out.println("<br><br>");
		out.println("<h1>Estado actual del carrito <h1/>");
		out.println("<br><br>");
		
		
		Set<String>prod = carrito.keySet();
		Iterator<String> itr=prod.iterator();
		while(itr.hasNext()) {
			String elemento =(String) itr.next();
			Integer cantidad=(Integer) carrito.get(elemento);
			if(cantidad!=0) {
				out.println("<h4>Producto: "+ elemento +";Cantidad: " +cantidad + "<h4/>");
			}
		}
		
		
		
		out.println("</BODY></HTML>");
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
