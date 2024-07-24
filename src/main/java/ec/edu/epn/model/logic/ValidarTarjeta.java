package ec.edu.epn.model.logic;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Stack;

/**
 * Clase ValidarTarjeta que proporciona métodos para validar la información de una tarjeta de crédito.
 * Incluye la validación del número de la tarjeta, la fecha de expiración y el código CVV.
 */
public class ValidarTarjeta {
    static Stack<Integer> pilaOriginalInvertida = new Stack<>();
    static String operacion = "";
    static String numeroOriginal;

    /**
     * Valida la tarjeta de crédito basándose en su número, fecha de expiración y CVV.
     *
     * @param numeroDeLaTarjeta El número de la tarjeta de crédito como un arreglo de caracteres.
     * @param fechaExpiracion La fecha de expiración de la tarjeta en el formato MM/yyyy.
     * @param cvv El código CVV de la tarjeta.
     * @return true si la tarjeta es válida, false en caso contrario.
     */
    public static boolean validarTarjeta(char[] numeroDeLaTarjeta, String fechaExpiracion, String cvv) {
        numeroOriginal = String.valueOf(numeroDeLaTarjeta);
        invertirOrden(numeroDeLaTarjeta);
        return validarNumeroDeLaTarjeta() && validarFechaDeExpiracion(fechaExpiracion) && validarCVV(cvv);
    }

    /**
     * Valida el código CVV de la tarjeta.
     *
     * @param cvv El código CVV de la tarjeta.
     * @return true si el CVV es válido, false en caso contrario.
     */
    private static boolean validarCVV(String cvv) {
        if (cvv == null) {
            return false;
        }
        return cvv.matches("\\d{3}");
    }

    /**
     * Valida la fecha de expiración de la tarjeta.
     *
     * @param fechaExpiracion La fecha de expiración de la tarjeta en el formato MM/yyyy.
     * @return true si la fecha de expiración es válida y no ha expirado, false en caso contrario.
     */
    private static boolean validarFechaDeExpiracion(String fechaExpiracion) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yyyy");
        try {
            YearMonth fecha = YearMonth.parse(fechaExpiracion, formatter);
            YearMonth ahora = YearMonth.now();
            return fecha.isAfter(ahora);
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    /**
     * Invierte el orden de los dígitos del número de la tarjeta.
     *
     * @param cadena El número de la tarjeta como un arreglo de caracteres.
     */
    private static void invertirOrden(char cadena[]){
        for (char c : cadena) {
            pilaOriginalInvertida.push(c-'0');
        }
    }

    /**
     * Valida el número de la tarjeta de crédito.
     *
     * @return true si el número de la tarjeta es válido según el algoritmo de Luhn, false en caso contrario.
     */
    private static boolean validarNumeroDeLaTarjeta(){
        int indice = 0;
        int nuevoNumero;
        int sumaMultiplo10=0;
        while(pilaOriginalInvertida.size()>0){
            if (indice%2==1) {
                int numeroDoble = pilaOriginalInvertida.peek()*2;
                if (numeroDoble>9) {
                    int segundoDigito = numeroDoble%10;
                    nuevoNumero = 1+ (segundoDigito);
                    sumaMultiplo10+=nuevoNumero;
                    operacion+="+(1+"+numeroDoble%10+")";
                }else{
                    sumaMultiplo10+=numeroDoble;
                    operacion+="+"+numeroDoble;
                }
            }else{
                sumaMultiplo10+=pilaOriginalInvertida.peek();
                operacion+= (indice==0 ? "" : "+" )+pilaOriginalInvertida.peek();
            }
            indice++;
            pilaOriginalInvertida.pop();
        }

        if (sumaMultiplo10%10==0) {
            return true;
        }else{
            return false;
        }
    }
}