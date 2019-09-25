package com.tew.Servlets.tienda;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CarritoCompraServlet
 */

@WebServlet(name = "/CarritoCompraServlet", urlPatterns = { "/CarritoCompraServlet" })
public class CarritoCompraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarritoCompraServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
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
		
		
		HashMap<String,Integer> carrito = (HashMap<String,Integer>)request.getSession().getAttribute("carrito");
		if ( carrito == null ) {
		 	carrito = new HashMap<String, Integer>();
		 
		}
				
		
		String producto = request.getParameter("producto");
		if ( producto != null ){
			Integer cantidad = (Integer) carrito.get(producto);
		 	if ( cantidad == null )
		 		 cantidad = new Integer ( 1 );
		 	else
		 	 cantidad = new Integer ( cantidad.intValue() + 1 );
		 	 	//Y añadimos el producto al carrito
		 	 	carrito.put(producto, cantidad);
		 	 	
		}
		out.print(carrito.get(producto));
		
		out.println("<br><br>");
		out.println("<h1>Estado actual del carrito <h1/>");
		out.println("<br><br>");
		
		Set<String>prod = carrito.keySet();
		Iterator<String> itr=prod.iterator();
		while(itr.hasNext()) {
			String elemento =(String) itr.next();
			Integer cantidad=(Integer) carrito.get(elemento);
			if(cantidad!=0) {
				out.println("Producto: "+ elemento +";Cantidad: " +cantidad);
			}
		}

		
		
		out.println("</FORM></BODY></HTML>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
