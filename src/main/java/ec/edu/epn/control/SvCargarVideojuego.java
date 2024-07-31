package ec.edu.epn.control;

import ec.edu.epn.model.entities.Videojuego;
import ec.edu.epn.model.logic.VideojuegoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.io.InputStream;


@WebServlet(name = "SvCargarVideojuego", value = "/SvCargarVideojuego")
@MultipartConfig
public class SvCargarVideojuego extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        VideojuegoDAO videojuegoDAO = new VideojuegoDAO();
        Videojuego videojuego = new Videojuego();
        String titulo = request.getParameter("titulo");
        videojuego.setTitulo(titulo);
        String desarrollador = request.getParameter("desarrollador");
        videojuego.setDesarrollador(desarrollador);
        String precio = request.getParameter("precio");
        videojuego.setPrecio(Double.parseDouble(precio));
        Part filePart = request.getPart("image");
        byte[] img = convertirBytes(filePart);
        videojuego.setImageData(img);
        // set the image already in base64
        videojuegoDAO.almacenarVideojuego(videojuego);
        response.sendRedirect("index.jsp");
    }
    public byte[] convertirBytes(Part archivoImagen) throws IOException {
        InputStream contenidoImagen = archivoImagen.getInputStream();
        return contenidoImagen.readAllBytes();
    }
    public static String encodeBase64(byte[] data) {
        return java.util.Base64.getEncoder().encodeToString(data);
    }
}
