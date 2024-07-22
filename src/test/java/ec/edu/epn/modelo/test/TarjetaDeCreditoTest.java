package ec.edu.epn.modelo.test;

import ec.edu.epn.model.logic.ValidarTarjeta;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;
import java.lang.String;


public class TarjetaDeCreditoTest {
    @Test
    public void given_tarjeta_fue_ingresado_when_quiera_pagar_then_aceptara_la_tarjeta() {
        String numeroTarjeta = "4857178587547167";
        String fechaExpiracion = "10/2026";
        String cvv = "967";

        assertTrue(ValidarTarjeta.validarTarjeta(numeroTarjeta.toCharArray(), fechaExpiracion, cvv));
    }

    @Test
    public void given_tarjeta_fue_ingresada_incorrectamente_when_quiera_pagar_then_rechazara_la_tarjeta() {
        String numeroTarjeta = "4857178587";
        String fechaExpiracion = "10/2026";
        String cvv = "967";

        assertFalse(ValidarTarjeta.validarTarjeta(numeroTarjeta.toCharArray(), fechaExpiracion, cvv));
    }

}
