/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hidalgo_Arriaga_Ubaldo_PROG_Tarea04.ejercicios;

import Hidalgo_Arriaga_Ubaldo_PROG_Tarea04.utilidades.ES;

/**
 *
 * Ejercicio para ubicar cadena de caracteres en otra cadena de partida.<br>
 * Ejemplo:<br>
 * Cadena base: <br>
 * ***#**#*****#****#******# ****** <br>
 * Cadena despues de composicion introduciendo los caracteres
 * <strong>abc</strong>:<br>
 * abc#**#*****#****#******#*******
 *
 * @author Ubaldo Hidalgo Arriaga
 */
public class Ejercicio2 {

    public static void main(String[] args) {
        String cadenaBase = "***#**#*****#****#******#*******";
        String cadenaUsuario = new String();
        StringBuilder resultado = new StringBuilder();
        int longitud;
        int contadorPosicion = 0;
        System.out.printf("La cadena de partida es la siguiente:\n %s \n", cadenaBase);
        do {

            cadenaUsuario = ES.leeCadena("Introduce una cadena de 2 a 7 "
                    + "caracteres para colocarla en lugar de los asteriscos: ");
            longitud = cadenaUsuario.length();

            if (longitud < 2 || longitud > 7) {
                System.err.println("Error. La cadena debe estar "
                        + "entre 2 y 7 caracteres.");
            }

        } while (longitud < 2 || longitud > 7);

        String[] ubicacion = cadenaBase.split("#");

        ubicaCadena(ubicacion, contadorPosicion, longitud, resultado, cadenaUsuario);
        resultado.deleteCharAt(resultado.length() - 1);
        System.out.println(resultado.toString());

    }

    /**
     * Metodo para determinar donde ubicar los caracteres del usuario.
     *
     * @param ubicacion array con las diferentes combinaciones de caracteres
     * posibles
     * @param contadorPosicion variable para determinar donde se deben de ubicar
     * los caracteres
     * @param longitud numero de caracteres insertados
     * @param resultado composicion de la cadena del usuario y la cadena base
     * @param cadenaUsuario cadena de caracteres insertada por el usuario.
     */
    private static void ubicaCadena(String[] ubicacion, int contadorPosicion, int longitud, StringBuilder resultado, String cadenaUsuario) {
        for (String cadena : ubicacion) {
            contadorPosicion++;
            if (cadena.length() == longitud) {
                resultado.append(cadenaUsuario);
                System.out.printf("La cadena '%s' fue emplazada en la posición "
                        + "'%d'.\n", cadenaUsuario, contadorPosicion);
            } else {
                resultado.append(cadena);
//                cadenaBase= cadenaBase.replaceFirst("$", ubicacion[cadena].);
//                System.out.println(cadenaBase);
            }

            resultado.append("#");
        }
    }
}
