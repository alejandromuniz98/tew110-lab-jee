package com.tew.Servlets.tienda;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.RequestDispatcher;
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
		request.getSession().setAttribute("carrito",carrito);
		
		
		
		
		
		
		

		
		
		
		
		RequestDispatcher dispatcher =
				 getServletContext().getNamedDispatcher("CarritoCompraVista");
				dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
