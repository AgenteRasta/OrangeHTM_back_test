package co.com.davivienda.utils;

public class StringUtils {

    public static String obtenerStringNecesario(String texto, String separador) {
        if (texto == null || separador == null) {
            return "";
        }
        int indice = texto.indexOf(separador);
        if (indice == -1) {
            return "";
        }
        return texto.substring(indice + separador.length()).trim();
    }
}
