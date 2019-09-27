<%@ page language="java" import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
 <meta http-equiv="Content-Type" content="text/html; utf-8">. . .
 <title>Calculadora</title>
 </head>
 <body>
 <h1>Calculadora</h1>
 <br>
 <form action="Calculadora.jsp" method="post">
 <br>
 <input type="text" name="num">
 <br>
 <input type="text" name="numero">
 <table>
 <tr>
 </tr>
 <tr>
 <td>
 <select name="Operacion" size="1">
 <option value="1">+</option>
 <option value="2">-</option>
 <option value="3">/</option>
 <option value="4">*</option>
 </select>
 </td>
 </tr>
 <tr>
 <td>
 <input type="submit" value="calcular">
 </td>
 </tr>
 </table>
 </form>
 
<%
String num=request.getParameter("num");
String numero=request.getParameter("numero");
String op=request.getParameter("Operacion");
request.getSession().setAttribute("num",num);
request.getSession().setAttribute("numero",numero);
request.getSession().setAttribute("op",op);

if(num!=null && op!=null && numero!=null){
Integer op1=Integer.parseInt(num);
Integer op2=Integer.parseInt(numero);
Integer res;


if(op.equals("1")){ 
	res=op1+op2;%>
	<center> Resultado= <%=res%></center>
<%}
else if (op.equals("2")){ 
	res=op1-op2;%>
	<center> Resultado= <%=res%></center>
<%}
else if (op.equals("4")){ 
	res=op1*op2;%>
	<center> Resultado= <%=res%></center>
<%}
else if (op.equals("3")){ 
	res=op1/op2;%>
	<center> Resultado= <%=res%></center>
<%}
else{ %>

	<center> Error</center>
<%}}

//request.getSession().setAttribute("carrito",carrito);
 %>
 



 
 </body>
<html>