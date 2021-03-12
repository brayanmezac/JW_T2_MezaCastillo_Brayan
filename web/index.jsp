<%-- 
    Document   : index
    Created on : 10/03/2021, 2:54:44 p. m.
    Author     : ikara
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Producto,java.util.ArrayList" %>
<%
    boolean isError = false;
    String error = "";
    if (request.getSession().getAttribute("error")!=null) {
        isError = true;
        error = (String)request.getSession().getAttribute("error");
    }
    
    ArrayList producto;
    if (request.getSession().getAttribute("productos")!=null) {
        producto=(ArrayList)request.getSession().getAttribute("productos");
    } else {
        producto=new ArrayList();
    }/**/
    
    %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="css/css.css" >
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </heaclass
    <body>
        <div id="cuerpo">
                    <%
                    if (isError) {
                    %>
                <h3><%=error%></h3>
                <%
                    }
                %>
                    <form action="AddProducto" method="POST">
                <input type="text" name="nombre" value="" class="box-input" placeholder="nombre">
               
                <input type="text" name="codigo" value="" class="box-input" placeholder="codigo">
                
                <input type="text" name="precio" value="" class="box-input" placeholder="precio">
                
                <input type="text" name="cantidad" value="" class="box-input" placeholder="cantidad">
                
                <input type="submit" value="Agregar" class="myButton"/>
                    </form><br>
                    
                
                <%
                    if (producto!=null && producto.size()>0) { 
                %>
                
                <table class="darkTable">
                    <thead>
                        <tr>
                            <th>Nombre</th>
                            <th>Codigo</th>
                            <th>Precio</th>
                            <th>Cantidad</th>
                            <th>Opciones</th>
                        </tr>
                    </thead>
        
                    <tbody>
                        <%
                            for (int i=0; i<producto.size(); i++) {
                                
                                Producto productos = (Producto)producto.get(i);
                                out.println("<tr>");
                                out.println("<td>"+productos.getNombre()+"</td>");
                                out.println("<td>"+productos.getCodigo()+"</td>");
                                out.println("<td>"+productos.getPrecio()+"</td>");
                                out.println("<td>"+productos.getCantidad()+"</td>");
                                out.println("<td><a href='DeleteProducto?pos="+i+"'>Eliminar</a></td>");
                                out.println("</tr>");
                            }
                        %>
                    </tbody>
                </table>
                <%
                    } else {
                        out.println("Sin Productos");
                    }
                %>
     
        </div>
    </body>
</html>
