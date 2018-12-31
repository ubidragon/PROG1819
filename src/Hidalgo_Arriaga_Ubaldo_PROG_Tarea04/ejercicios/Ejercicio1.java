/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hidalgo_Arriaga_Ubaldo_PROG_Tarea04.ejercicios;

import utilidades.ES;

/**
 * Ejercicio que pretende generar un dibujo en base a una cadena de numeros.
 * Ejemplo de dibujo:<br>
 * <code>|  345|<br>
 * |1 45|<br>
 * |12 5|<br>
 * |123 |<br>
 * |123 |<br>
 * |12 5|<br>
 * |1 45|<br>
 * | 345|</code>
 *
 * @author Ubaldo Hidalgo Arriaga
 */
public class Ejercicio1 {

    /**
     * Metodo principal para ejecutar la clase.
     *
     * @param args datos de la interaccion del usuario.
     */
    public static void main(String[] args) {
        String cadena = new String();
        StringBuilder msg = new StringBuilder();
        int longitud;

        cadena = checkLongitud(cadena);
        longitud = cadena.length();
        System.out.printf("Cadena inicial: %s \n", cadena);

        poneHuecos(longitud, msg, cadena);

        System.out.println(msg.toString());
    }

    /**
     * Metodo para comprobar que se cumple el requisito de almenos 5 caracteres
     *
     * @param cadena los numeros que forman la cadena
     * @return cadena de numeros valida
     */
    private static String checkLongitud(String cadena) {
        do {
            cadena = String.valueOf(ES.leeCadena("Introduzca una cadena de numeros"));
            if (cadena.length() < 5) {
                ES.msgln("Error. Introduce una cadena de al menos 5 caracteres");
            }
        } while (cadena.length() < 5);
        return cadena;
    }

    /**
     * Metodo privado para la ubicacion de huecos en blanco en la cadena de
     * numeros
     *
     * @param longitud es la medida total de caracteres
     * @param msg variable que almacenara el resultado de irr colocando espacios
     * @param cadena los numeros que forman la cadena.
     */
    private static void poneHuecos(int longitud, StringBuilder msg, String cadena) {
        for (int i = 0; i < longitud - 1; i++) {

            msg.append("|");
            if (i == 0) {
                msg.append("  ").append(cadena.substring(i + 2, longitud));
            } else {

                msg.append(cadena.substring(0, i)).append("  ").append(cadena.substring(i + 2));
            }
            msg.append("|\n");

        }
        for (int i = longitud - 1; i > 0; i--) {

            msg.append("|");
            if (i == longitud - 1) {
                msg.append(cadena.substring(0, i - 1)).append("  ");
            } else {
                msg.append(cadena.substring(0, i - 1)).append("  ").append(cadena.substring(i + 1));

            }
            msg.append("|\n");

        }
    }
}
