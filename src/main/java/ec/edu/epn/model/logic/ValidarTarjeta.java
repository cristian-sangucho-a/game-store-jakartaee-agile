package ec.edu.epn.model.logic;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Stack;

public class ValidarTarjeta {
    static Stack<Integer> pilaOriginalInvertida = new Stack<>();
    static String operacion = "";
    static String numeroOriginal;

    public static boolean validarTarjeta(char[] numeroDeLaTarjeta, String fechaExpiracion, String cvv) {
        numeroOriginal = String.valueOf(numeroDeLaTarjeta);
        invertirOrden(numeroDeLaTarjeta);
        return validarNumeroDeLaTarjeta() && validarFechaDeExpiracion(fechaExpiracion) && validarCVV(cvv);
    }

    private static boolean validarCVV(String cvv) {
        if (cvv == null) {
            return false;
        }
        return cvv.matches("\\d{3}");
    }

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

    private static void invertirOrden(char cadena[]){
        for (char c : cadena) {
            pilaOriginalInvertida.push(c-'0');
        }
    }

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
