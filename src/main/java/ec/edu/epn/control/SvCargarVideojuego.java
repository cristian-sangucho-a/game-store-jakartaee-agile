package ec.edu.epn.control;

import ec.edu.epn.model.entities.Videojuego;
import ec.edu.epn.model.logic.VideojuegoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;


@WebServlet(name = "SvCargarVideojuego", value = "/SvCargarVideojuego")
public class SvCargarVideojuego {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        VideojuegoDAO videojuegoDAO = new VideojuegoDAO();
        Videojuego videojuego = new Videojuego();
        videojuego.setTitulo(request.getParameter("titulo"));
        videojuego.setDesarrollador(request.getParameter("desarrollador"));
        videojuego.setPrecio(Double.parseDouble(request.getParameter("precio")));
        Part filePart = request.getPart("image");
        byte[] img = videojuegoDAO.convertirBytes(filePart);
        videojuego.setImageData(img); //seteo la imagen ya en base64
        videojuegoDAO.almacenarVideojuego(videojuego);
    }
}
