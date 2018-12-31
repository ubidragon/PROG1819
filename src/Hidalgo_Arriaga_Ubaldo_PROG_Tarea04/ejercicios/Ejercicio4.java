/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hidalgo_Arriaga_Ubaldo_PROG_Tarea04.ejercicios;

import utilidades.ES;

/**
 *
 * Ejercicio para generar cadenas de numeros aleatorias.
 *
 * @author Ubaldo Hidalgo Arriaga
 */
public class Ejercicio4 {

    /**
     * Numero maximo que se desea generar
     */
    static int maximo;

    /**
     * Numero de caracteres de la secuencia.
     */
    static int minimo;

    public static void main(String[] args) {
        StringBuilder msg = new StringBuilder("Introduce el número máximo (entre 10 y 100):");
        System.out.println(msg.toString());

        checkMaximo(msg);
        int max2 = maximo - 2;
        msg.append("Introduce la cantidad de números a escoger entre 2 y ").append(max2);
        System.out.println(msg);
        checkMinimo(msg);

        int[] numerosEscoger = new int[minimo];
        generaCombinaciones(msg, numerosEscoger);

    }

    /**
     * metodo auxiliar para generar las combinaciones aleatorias de numeros
     *
     * @param msg variable para almacenar el texto a mostrar al usuario
     * @param numerosEscoger array donde se almacenaran las secuencias de
     * numeros
     */
    private static void generaCombinaciones(StringBuilder msg, int[] numerosEscoger) {
        boolean parada = true;
        do {
            boolean status = true;

            msg.delete(0, msg.length());

            for (int i = 0; i < minimo; i++) {
                numerosEscoger[i] = (int) Math.round(Math.random() * (maximo - 2)) + 2;
            }

            parada = checkAceptacion(numerosEscoger, status, msg, parada);
            for (int i : numerosEscoger) {
                msg.append(i).append(" ");
            }
            System.out.println(msg.toString());
        } while (parada);
    }

    /**
     * Metodo auxiliar para comprobar si la cadena de numeros es aceptada o no
     *
     * @param numerosEscoger numeros generados
     * @param status variable para determinar si es aceptada o no
     * @param msg variable para almacenar el texto a mostrar al usuario
     * @param parada variable para indicar cuando parar el bucle en el que se
     * usa este metodo
     * @return el estado de si debe de continuar el bucle.
     */
    private static boolean checkAceptacion(int[] numerosEscoger, boolean status, StringBuilder msg, boolean parada) {
        for (int i = 0; i < numerosEscoger.length; i++) {
            for (int j = i + 1; j < numerosEscoger.length; j++) {
                if (numerosEscoger[i] == numerosEscoger[j]) {
                    status = false;
                }
            }
        }
        if (status == true) {
            msg.append("Aceptado: ");
            parada = false;
        } else {

            msg.append("Denegado: ");
        }
        return parada;
    }

    /**
     * Metodo auxiliar para determinar si se cumple que la longitud determinada
     * es correcta
     *
     * @param msg variable para almacenar el texto a mostrar al usuario
     */
    private static void checkMinimo(StringBuilder msg) {

        do {
            msg.delete(0, msg.length());
            minimo = ES.leeEntero();
            if (minimo < 2 || minimo > (maximo - 2)) {
                int max2 = maximo - 2;
                msg.append("Error: Debe ser un número entero entre 2 y ").append(max2);
                msg.append("\nIntroduce la cantidad de números a escoger entre 2 y ").append(max2);
            }
            System.out.println(msg.toString());

        } while (minimo < 2 || minimo > (maximo - 2));
    }

    /**
     * Metodo auxiliar para determinaer que no se excede el maximo ni se
     * introduce un valor por debo del minimo.
     *
     * @param msg variable para almacenar el texto a mostrar al usuario
     */
    private static void checkMaximo(StringBuilder msg) {

        do {
            msg.delete(0, msg.length());
            maximo = ES.leeEntero();
            if (maximo < 10 || maximo > 100) {
                msg.append("Error: Debe ser un número entero entre 10 y 100.");
            }
            System.out.println(msg.toString());

        } while (maximo < 10 || maximo > 100);
    }
}
