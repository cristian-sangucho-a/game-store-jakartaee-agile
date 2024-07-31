package ec.edu.epn.modelo.test;

import ec.edu.epn.model.entities.Biblioteca;
import ec.edu.epn.model.entities.Cliente;
import ec.edu.epn.model.entities.Videojuego;
import ec.edu.epn.model.logic.BibliotecaDAO;
import ec.edu.epn.model.logic.ClienteDAO;
import ec.edu.epn.model.logic.VideojuegoDAO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClienteTest {
    ClienteDAO clienteDAO;
    Cliente cliente;

    @Before
    public void setUpClass() {
        clienteDAO = new ClienteDAO();
        cliente = new Cliente("Cristian", "Zambrano","cristian.zambrano@gmail.com", "123456", false);
        try{
            clienteDAO.almacenarCliente(cliente);
        }catch (Exception e){
            e.printStackTrace();
        }

    }


    @Test
    public void given_cliente_en_login_when_introduzca_usuario_correcto_y_contrasenia_correcta_then_se_muestra_index(){
        assertEquals(0, clienteDAO.existeCliente(cliente)); //existe el cliente con correo y contrasenia
        System.out.println("Acceso permitido, redirigiendo a index.jsp");
    }

    @Test
    public void given_cliente_en_login_when_introduzca_contrasenia_incorrecta_then_se_muestra_formulario_registro(){
        cliente.setContrasenia("malacontra");
        assertTrue(clienteDAO.existeCliente(cliente) == 1); //solo existe el correo, contrasena mal
        System.out.println("Acceso denegado, contrasenia incorrecta, introduzca de nuevo sus credenciales en login.jsp");
    }

    @Test
    public void given_cliente_en_login_when_introduzca_usuario_incorrecto_y_contrasenia_incorrecta_then_se_muestra_index() {
        cliente.setCorreo("cristian.apellido@gmail.com");
        cliente.setContrasenia("202020");
        assertTrue(clienteDAO.existeCliente(cliente) == 2); //no existe el usuario
        System.out.println("Acceso denegado, cliente no existe, redirigiendo a registrarse.jsp");
    }

    @Test
    public void given_cliente_en_la_tienda_when_vaya_a_biblioteca_then_se_muestran_videojuegos_comprados(){
        Cliente clienteBD = clienteDAO.obtenerCliente(cliente);
        VideojuegoDAO videojuegoDAO = new VideojuegoDAO();
        Videojuego videojuego = videojuegoDAO.obtenerVideojuegoPorId(169);

        BibliotecaDAO bibliotecaDAO = new BibliotecaDAO();
        try{
            bibliotecaDAO.agregarVideojuego(videojuego, clienteBD.getBiblioteca());
        }catch (Exception e){
            e.printStackTrace();
        }


        assertTrue(!clienteBD.getBiblioteca().getVideojuegos().isEmpty());
    }

}