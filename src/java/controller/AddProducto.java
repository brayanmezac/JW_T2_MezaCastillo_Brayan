/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Producto;

/**
 *
 * @author ikara
 */
@WebServlet(name = "AddProducto", urlPatterns = {"/AddProducto"})
public class AddProducto extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String nombre = (String) request.getParameter("nombre");
        String codigo = (String) request.getParameter("codigo");
        String precio = (String) request.getParameter("precio");
        String cantidad = (String) request.getParameter("cantidad");
        
        if (esValido(nombre) && esValido(codigo)) {
            Producto producto = new Producto();
            producto.setNombre(nombre);
            producto.setCodigo(codigo);
            producto.setPrecio(precio);
            producto.setCantidad(cantidad);
            if (request.getSession().getAttribute("productos")!=null &&
                 request.getSession().getAttribute("productos") instanceof ArrayList) {
                ((ArrayList) request.getSession().getAttribute("productos")).add(producto);
            } else {
                request.getSession().setAttribute("productos", new ArrayList());
                ((ArrayList) request.getSession().getAttribute("productos")).add(producto);
            }
            //request.getSession().removeAttribute("error");
        } else {
            request.getSession().setAttribute("error", "Nombre y/o Apellido no validos");
            request.getSession().removeAttribute("productos");
        }
        response.sendRedirect("index.jsp");
    }
private boolean esValido(String campo) {
        if (campo!=null && campo.length()>0) {
            return true;
        } else {
            return false;
        }
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
