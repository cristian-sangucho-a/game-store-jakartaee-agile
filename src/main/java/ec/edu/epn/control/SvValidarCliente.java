package ec.edu.epn.control;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

import ec.edu.epn.model.entities.Cliente;
import ec.edu.epn.model.logic.ClienteDAO;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet controlador para manejar la creación de cuentas de clientes.
 */
@WebServlet(name = "SvValidarCliente", value = "/SvValidarCliente")
public class SvValidarCliente extends HttpServlet {
    /**
     * Maneja las solicitudes POST del cliente para la creación de una cuenta.
     *
     * @param request  el HttpServletRequest que contiene la solicitud del cliente
     * @param response el HttpServletResponse que contiene la respuesta del servlet
     * @throws ServletException si ocurre un error específico del servlet
     * @throws IOException      si ocurre un error de entrada/salida
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sessionInicio = request.getSession();
        Cliente cliente = (Cliente) sessionInicio.getAttribute("cliente");
        String direccion;
        if (cliente == null) {
            direccion = "iniciarSesion.jsp";
        } else {
            direccion = "ingresoTarjeta.jsp";
        }
        response.sendRedirect(direccion);
    }
}