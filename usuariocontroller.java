package com.emergentes.controlador;

import com.emergentes.dao.usuariodao;
import com.emergentes.dao.usuariodaoimplemento;
import com.emergentes.modelo.usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "usuariocontroller", urlPatterns = {"/usuariocontroller"})
public class usuariocontroller extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        usuario u = new usuario();
        usuariodao udao = new usuariodaoimplemento();
        int id;
        String op = (request.getParameter("op") != null) ? request.getParameter("op") : "vista";

        switch (op) {
            case "nuevo":
                request.setAttribute("listausuario", u);
                request.getRequestDispatcher("frmusuario.jsp").forward(request, response);
                break;
            case "editar":
                id = Integer.parseInt(request.getParameter("id"));
                 {
                    try {
                        u = udao.getByid(id);
                    } catch (Exception ex) {
                        System.out.println("Error al editar" + ex.getMessage());
                    }
                }
                request.setAttribute("listausuario", u);
                request.getRequestDispatcher("frmusuario.jsp").forward(request, response);
                break;

            case "eliminar":
                id = Integer.parseInt(request.getParameter("id"));
                 {
                    try {
                        udao.eliminar(id);
                    } catch (Exception ex) {
                        System.out.println("Error al eliminar" + ex.getMessage());
                    }
                }
                response.sendRedirect("usuariocontroller");
                break;

            case "vista":
                List<usuario> lista = new ArrayList<usuario>();
                 {
                    try {
                        lista = udao.getAll();
                    } catch (Exception ex) {
                        System.out.println("Error al mostrar" + ex.getMessage());
                    }
                }
                request.setAttribute("lista", lista);
                request.getRequestDispatcher("usuarios.jsp").forward(request, response);
                break;
            default:
                break;

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        usuariodao udao = new usuariodaoimplemento();
        usuario u = new usuario();

        int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        String correo = request.getParameter("correo");
        String clave = request.getParameter("clave");

        u.setId(id);
        u.setNombre(nombre);
        u.setCorreo(correo);
        u.setClave(clave);

        if (id == 0) {
            try {
                udao.insertar(u);
            } catch (Exception ex) {
                System.out.println("Erro al Insertar" + ex.getMessage());
            }
        } else if (id != 0) {
            try {
                udao.actualizar(u);
            } catch (Exception ex) {
                System.out.println("Error al Editar" + ex.getMessage());
            }
        }
        response.sendRedirect("usuariocontroller");
    }
}
