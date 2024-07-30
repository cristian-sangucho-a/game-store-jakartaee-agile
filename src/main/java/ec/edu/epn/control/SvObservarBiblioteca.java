package ec.edu.epn.control;
import jakarta.servlet.ServletException;
import ec.edu.epn.model.entities.Cliente;
import ec.edu.epn.model.entities.Pago;
import ec.edu.epn.model.logic.PagoDAO;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.util.List;

@WebServlet(name = "SvObservarBiblioteca", value = "/SvObservarBiblioteca")
public class SvObservarBiblioteca extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException{
        HttpSession session = request.getSession();
        Cliente cliente = (Cliente) session.getAttribute("cliente");
        Biblioteca biblioteca = cliente.getBiblioteca();
        request.setAttribute("biblioteca", biblioteca);
        try {
            request.getRequestDispatcher("biblioteca.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
