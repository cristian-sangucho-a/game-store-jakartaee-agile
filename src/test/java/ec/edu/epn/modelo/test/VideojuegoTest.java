package ec.edu.epn.modelo.test;

import ec.edu.epn.model.Videojuego;
import ec.edu.epn.model.VideojuegoDAO;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class VideojuegoTest {

public static VideojuegoDAO videojuegoDAO;

    @BeforeClass
    public static void setUpClass() {
        videojuegoDAO = new VideojuegoDAO();
    }
    @Test
    public void given_titulo_when_usuario_busque_then_obtener_coincidencias() {
        // Crear una lista de videojuegos para simular lo que retornaría la base de datos
        String tituloEntrante = "Persona";
        List<Videojuego> resultado =videojuegoDAO.obtenerVideojuegoPorTitulo(tituloEntrante);
        System.out.println(resultado.size());
        assertFalse(resultado.isEmpty());
    }

    @Test
    public void given_titulo_when_usuario_busque_then_no_obtener_coincidencias(){
       String tituloEntrante = "Batalla Naval Simon Bolivar";
        //no se obtiene ninguna coincidencia
        List<Videojuego> resultado =videojuegoDAO.obtenerVideojuegoPorTitulo(tituloEntrante);
        assertTrue(resultado.isEmpty());

    }

    @Test
    public void given_rango_precio_when_usuario_busque_then_obtener_coincidencias(){
        double precioMinimo = 15.00;
        double precioMaximo = 25.00;
        List<Videojuego> resultado =videojuegoDAO.obtenerVideojuegosPorRangoDePrecio(precioMinimo, precioMaximo);
        System.out.println(resultado.size());
        assertFalse(resultado.isEmpty());
    }

    @Test
    public void given_rango_precio_when_usuario_busque_then_no_obtener_coincidencias(){
       double precioMinimo = 155.00;
       double precioMaximo = 205.00;
        List<Videojuego> resultado =videojuegoDAO.obtenerVideojuegosPorRangoDePrecio(precioMinimo, precioMaximo);
       assertTrue(resultado.isEmpty());
    }
    @Test
    public void given_desarrollador_when_usuario_busque_then_obtener_coincidencias() {
        // Crear una lista de videojuegos para simular lo que retornaría la base de datos
        String nombreDesarrollador = "Nintendo";
        List<Videojuego> resultado =videojuegoDAO.obtenerVideojuegoPorDesarrollador(nombreDesarrollador);
        assertFalse(resultado.isEmpty());
    }

    @Test
    public void given_desarrollador_when_usuario_busque_then_no_obtener_coincidencias(){
       String nombreDesarrollador = "Cristian Zambrano";

       List<Videojuego> resultado = videojuegoDAO.obtenerVideojuegoPorDesarrollador(nombreDesarrollador);
       assertTrue(resultado.isEmpty());
    }

    @Test
    public void given_inicio_when_ver_catalogo_then_mostrar_catalogo_videojuego(){
       List<Videojuego> videojuegos = new ArrayList<>();
       List<Videojuego> catalogo = videojuegoDAO.obtenerTodosLosVideojuego();
       assertFalse(catalogo.isEmpty());
    }

}
