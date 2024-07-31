package ec.edu.epn.modelo.test;

import ec.edu.epn.model.entities.Videojuego;
import ec.edu.epn.model.logic.VideojuegoDAO;
import org.junit.BeforeClass;
import org.junit.Test;


import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


public class VideojuegoTest {

public static VideojuegoDAO videojuegoDAO;

    @BeforeClass
    public static void setUpClass() {
        videojuegoDAO = new VideojuegoDAO();
    }

    /**
     * Prueba para definir que cuando se busque por un título, entonces obtenga una lista no vacía
     */
    @Test
    public void given_titulo_when_usuario_busque_then_obtener_coincidencias() {
        // Crear una lista de videojuegos para simular lo que retornaría la base de datos
        String tituloEntrante = "Borderland";
        List<Videojuego> resultado =videojuegoDAO.obtenerVideojuegoPorTitulo(tituloEntrante);
        System.out.println(resultado.size());
        assertFalse(resultado.isEmpty());
    }

    /**
     * Prueba para definir que al buscar por título entonces obtenga una lista vacía de resultados
     */
    @Test
    public void given_titulo_when_usuario_busque_then_no_obtener_coincidencias(){
       String tituloEntrante = "Batalla Naval Simon Bolivar";
        //no se obtiene ninguna coincidencia
        List<Videojuego> resultado =videojuegoDAO.obtenerVideojuegoPorTitulo(tituloEntrante);
        assertTrue(resultado.isEmpty());

    }

    /**
     * Prueba para definir que en un rango de precio, cuando el usuario busque entonces obtenga una lista
     * de videojuegos
     */
    @Test
    public void given_rango_precio_when_usuario_busque_then_obtener_coincidencias(){
        double precioMinimo = 15.00;
        double precioMaximo = 25.00;
        List<Videojuego> resultado =videojuegoDAO.obtenerVideojuegosPorRangoDePrecio(precioMinimo, precioMaximo);
        System.out.println(resultado.size());
        assertFalse(resultado.isEmpty());
    }

    /**
     * Prueba para definir que al buscar por un rango de precio no obtenga coincidencias
     */
    @Test
    public void given_rango_precio_when_usuario_busque_then_no_obtener_coincidencias(){
       double precioMinimo = 155.00;
       double precioMaximo = 205.00;
        List<Videojuego> resultado =videojuegoDAO.obtenerVideojuegosPorRangoDePrecio(precioMinimo, precioMaximo);
       assertTrue(resultado.isEmpty());
    }

    /**
     * Prueba para definir que al buscar un videojuego por desarrollador obtiene una lista no vacía
     */
    @Test
    public void given_desarrollador_when_usuario_busque_then_obtener_coincidencias() {
        // Crear una lista de videojuegos para simular lo que retornaría la base de datos
        String nombreDesarrollador = "EA Sports";
        List<Videojuego> resultado =videojuegoDAO.obtenerVideojuegoPorDesarrollador(nombreDesarrollador);
        assertFalse(resultado.isEmpty());
    }

    /**
     * Prueba para para definir que el usuario busca por desarrollador y no obtiene coincidencias
     */
    @Test
    public void given_desarrollador_when_usuario_busque_then_no_obtener_coincidencias(){
       String nombreDesarrollador = "Cristian Zambrano";

       List<Videojuego> resultado = videojuegoDAO.obtenerVideojuegoPorDesarrollador(nombreDesarrollador);
       assertTrue(resultado.isEmpty());
    }

    /**
     * Prueba para mostrar el catálogo del cliente al abrir el aplicativo de inicio
     */
    @Test
    public void given_inicio_when_ver_catalogo_then_mostrar_catalogo_videojuego(){
       List<Videojuego> videojuegos = new ArrayList<>();
       List<Videojuego> catalogo = videojuegoDAO.obtenerTodosLosVideojuego();
       assertFalse(catalogo.isEmpty());
    }

    @Test
    public void given_formulario_when_ingrese_datos_videojuego_correctamente_then_mostrar_correctamente_videojuego_y_subirlo(){
        Videojuego videojuego = new Videojuego();
        videojuego.setDesarrollador("Jean Pierre");
        videojuego.setTitulo("Mindustry");
        videojuego.setPrecio(20.56);
        videojuego.setImageData(new byte[] {0,0,0,0});

        videojuegoDAO.almacenarVideojuego(videojuego);

        Videojuego videojuegoGuardado = (Videojuego) videojuegoDAO.obtenerVideojuegoPorId(videojuego.getId());

        assertTrue(videojuegoGuardado.equals(videojuego));

        videojuegoDAO.eliminarVideojuegoPorId(videojuegoGuardado.getId());
    }

}
