package ec.edu.epn.control;

import ec.edu.epn.model.entities.Biblioteca;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

import ec.edu.epn.model.entities.Cliente;
import ec.edu.epn.model.logic.ClienteDAO;

/**
 * Servlet controlador para manejar la creación de cuentas de clientes.
 */
@WebServlet(name = "SvRegistrarUsuario", value = "/SvRegistrarUsuario")
public class SvRegistrarUsuario extends HttpServlet {
    /**
     * Maneja las solicitudes POST del cliente para la creación de una cuenta.
     *
     * @param request  el HttpServletRequest que contiene la solicitud del cliente
     * @param response el HttpServletResponse que contiene la respuesta del servlet
     * @throws ServletException si ocurre un error específico del servlet
     * @throws IOException      si ocurre un error de entrada/salida
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        //Formulario de registro
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String correo = request.getParameter("correo");
        String contrasenia = request.getParameter("contrasena");
        boolean checkAdmin = Boolean.parseBoolean(request.getParameter("checkAdmin"));
        //Crear un nuevo cliente con los datos ingresados
        Cliente nuevoCliente = new Cliente();
        nuevoCliente.setBiblioteca(new Biblioteca(nombre + "_Biblioteca"));
        nuevoCliente.setNombre(nombre);
        nuevoCliente.setApellido(apellido);
        nuevoCliente.setCorreo(correo);
        nuevoCliente.setContrasenia(contrasenia);
        nuevoCliente.setEsAdmin(checkAdmin);
        //Llamada al DAO para guardar el nuevo cliente en la base de datos
        ClienteDAO clienteDAO = new ClienteDAO();
        int estadoCliente = clienteDAO.existeCliente(nuevoCliente);
        switch (estadoCliente){
            case 0:
            case 1:
                response.sendRedirect("registrarse.jsp");
                break;

            case 2:
                clienteDAO.almacenarCliente(nuevoCliente);
                response.sendRedirect("iniciarSesion.jsp");
                break;

        }
    }
}
