/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hidalgo_Arriaga_Ubaldo_PROG_Tarea08;

import java.util.HashSet;
import java.util.Set;
import util.ES;

/**
 *
 * @author ubidragon
 */
public class Ejercicio_00 {

    /**
     * Constante con el numero minimo a insertar
     */
    private static final int MINIMO = 1;

    public static void main(String[] args) {

        Set<Integer> conjuntoAleatorio = new HashSet<>();

        int maximo = ES.leeEntero("Introduce el valor de N:", MINIMO);

        insertNumeroConjunto(conjuntoAleatorio, maximo);

        StringBuilder msg = listaConjunto(conjuntoAleatorio);

        ES.msg(msg.toString());
    }

    /**
     * Metodo privado que añade numeros al conjunto
     * @param conjuntoAleatorio conjunto a rellenar
     * @param maximo numero maximo de numeros que tendra el conjunto
     */
    private static void insertNumeroConjunto(Set<Integer> conjuntoAleatorio, int maximo) {
        do {
            conjuntoAleatorio.add(generaAleatorios(maximo));
        } while (conjuntoAleatorio.size() < maximo);
    }

    /**
     * Metodo para pintar el conjunto de numeros generado
     * @param conjuntoAleatorio conjunto a mostrar
     * @return mensaje con el conjunto
     */
    private static StringBuilder listaConjunto(Set<Integer> conjuntoAleatorio) {
        StringBuilder msg = new StringBuilder("Los números son: ");
        for (Integer numero : conjuntoAleatorio) {
            msg.append(numero).append(" ");
        }
        return msg;
    }

    /**
     * Generador de numeros aleatorios
     * @param num_maximo numero maximo permitido para generar
     * @return numero aleatorio
     */
    private static int generaAleatorios(int num_maximo) {
        int nuevo = (int) (Math.random() * (MINIMO - 2 * num_maximo) + 2 * num_maximo);
        return nuevo;
    }

}
