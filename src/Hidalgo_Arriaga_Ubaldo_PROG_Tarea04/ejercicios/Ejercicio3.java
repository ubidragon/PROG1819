/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hidalgo_Arriaga_Ubaldo_PROG_Tarea04.ejercicios;

import Hidalgo_Arriaga_Ubaldo_PROG_Tarea04.utilidades.ES;

/**
 *
 * Ejercicio para la colocacion de numeros dentro de un array, desplazando o
 * suprimiendo otros elementos.
 *
 * @author Ubaldo Hidalgo Arriaga
 */
public class Ejercicio3 {

    public static void main(String[] args) {
        int[] cadenaNumeros = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        int numeroInsert = 0;
        StringBuilder msg
                = new StringBuilder("El array inicialmente es: [10, 20, 30, 40, 50, 60, 70, 80, 90, 100]");
        msg.append("\nEscribe un entero a insertar en el array. El -100 para acabar.");
        System.out.println(msg.toString());
        do {
            msg.delete(0, msg.length());
            numeroInsert = ES.leeEntero();

            localizaNuevaPosicion(cadenaNumeros, numeroInsert, msg);

            msg.append("\nEscribe un entero a insertar en el array. El -100 para acabar");
            System.out.println(msg.toString());

        } while (numeroInsert != -100);

    }

    /**
     * Metodo auxiliar para localizar donde se colocará el nuevo numero
     *
     * @param cadenaNumeros array de numeros donde insertaremos el nuevo valor.
     * @param numeroInsert numero insertado por el usuario.
     * @param msg variable para la composicion de los elementos que se
     * imprimiran por pantalla.
     */
    private static void localizaNuevaPosicion(int[] cadenaNumeros, int numeroInsert, StringBuilder msg) {
        for (int i = 0; i < (cadenaNumeros.length - 1); i++) {
            if (numeroInsert >= cadenaNumeros[cadenaNumeros.length - 1] || numeroInsert == cadenaNumeros[i]) {
                msg.delete(0, msg.length());
                generaTextoArray(cadenaNumeros, msg);
            }
            if (numeroInsert > cadenaNumeros[i] && numeroInsert < cadenaNumeros[i + 1] && i + 1 < cadenaNumeros.length) {
                for (int j = cadenaNumeros.length - 1; j > i + 1; j--) {
                    cadenaNumeros[j] = cadenaNumeros[j - 1];
                }
                cadenaNumeros[i + 1] = numeroInsert;
                generaTextoArray(cadenaNumeros, msg);
            } else if (numeroInsert < cadenaNumeros[0]) {
                for (int j = cadenaNumeros.length - 1; j > i; j--) {
                    cadenaNumeros[j] = cadenaNumeros[j - 1];
                }
                cadenaNumeros[i] = numeroInsert;
                generaTextoArray(cadenaNumeros, msg);
            }
        }
    }

    private static void generaTextoArray(int[] cadenaNumeros, StringBuilder msg) {
        msg.append("El array actual: [");

        for (int cadenaNumero : cadenaNumeros) {
            msg.append(cadenaNumero);
            msg.append(", ");
        }
        msg.deleteCharAt(msg.lastIndexOf(",")).append("]");
    }
}
