package ec.edu.epn.modelo.test;

import ec.edu.epn.model.entities.Cliente;
import ec.edu.epn.model.logic.ClienteDAO;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClienteTest {
    ClienteDAO clienteDAO;
    Cliente cliente;

    @Before
    public void setUpClass() {
        clienteDAO = new ClienteDAO();
        cliente = new Cliente("cristian.zambrano@gmail.com", "123456", false);
        clienteDAO.almacenarCliente(cliente);
    }

    /*
    * Escenario 1: Acceso exitoso de un usuario.
    Dado que el cliente esta en el formulario login
    Cuando llene los datos de usuario y contraseña para el acceder al sistema de manera correcta
    Entonces se permitirá el acceso al sistema mostrando la pagina principal del sistema (index.jsp)
    */
    @Test
    public void given_cliente_en_login_when_introduzca_usuario_correcto_y_contrasenia_correcta_then_se_muestra_index(){
        assertEquals(0, clienteDAO.existeCliente(cliente)); //existe el cliente con correo y contrasenia
        System.out.println("Acceso permitido, redirigiendo a index.jsp");
    }

    /*Escenario 2: Acceso denegado por usuario no registrado.
    Dado que el cliente esta en el login
    Cuando llene los datos de usuario y contraseña para el acceder y este correo no exista
    Entonces se mostrara el formulario de registro.
     * */
    @Test
    public void given_cliente_en_login_when_introduzca_contrasenia_incorrecta_then_se_muestra_formulario_registro(){
        cliente.setContrasenia("malacontra");
        assertTrue(clienteDAO.existeCliente(cliente) == 1); //solo existe el correo, contrasena mal
        System.out.println("Acceso denegado, contrasenia incorrecta, introduzca de nuevo sus credenciales en login.jsp");
    }

    /*
    Escenario 3: Acceso denegado por contraseña incorrecta.
    Dado que el cliente esta en el formulario login
    Cuando llene los datos de usuario y contraseña, y la contraseña no sea correcta
    Entonces se mostrara nuevamente el formulario de login.
     * */
    @Test
    public void given_cliente_en_login_when_introduzca_usuario_incorrecto_y_contrasenia_incorrecta_then_se_muestra_index() {
        cliente.setCorreo("cristian.apellido@gmail.com");
        cliente.setContrasenia("202020");
        assertFalse(clienteDAO.existeCliente(cliente) == 2); //no existe el usuario
        System.out.println("Acceso denegado, cliente no existe, redirigiendo a registrarse.jsp");
    }
}