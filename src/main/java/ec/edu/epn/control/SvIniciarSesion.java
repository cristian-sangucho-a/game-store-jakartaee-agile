package ec.edu.epn.control;

import ec.edu.epn.model.entities.Cliente;
import ec.edu.epn.model.logic.ClienteDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "SvIniciarSesion", value = "/SvIniciarSesion")
public class SvIniciarSesion extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String correo = request.getParameter("correo");
        String contrasena = request.getParameter("contrasena");
        Cliente clienteaAutenticar = new Cliente();
        clienteaAutenticar.setCorreo(correo);
        clienteaAutenticar.setContrasenia(contrasena);

        ClienteDAO clienteDAO = new ClienteDAO();
        Cliente clienteAutenticado;
        switch (clienteDAO.existeCliente(clienteaAutenticar)){
            case 0:
                clienteAutenticado = clienteDAO.obtenerCliente(clienteaAutenticar);
                HttpSession session = request.getSession();
                session.setAttribute("cliente", clienteAutenticado);
                request.getRequestDispatcher("index.jsp").forward(request, response);
                break;
            case 1:
                request.getRequestDispatcher("iniciarSesion.jsp").forward(request, response);
                break;
            case 2:
                request.getRequestDispatcher("registrarse.jsp").forward(request, response);
                break;
            default:
                break;
        }

    }
}
