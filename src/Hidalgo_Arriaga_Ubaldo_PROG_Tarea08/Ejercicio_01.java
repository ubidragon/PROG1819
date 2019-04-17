/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hidalgo_Arriaga_Ubaldo_PROG_Tarea08;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import util.ES;

/**
 *
 * @author ubidragon
 */
public class Ejercicio_01 {

    /**
     * Numero minimo de numero aleatorio a generar
     */
    private static final Integer MINIMO = 1;
    /**
     * Numero maximo de numero aleatorio a generar
     */
    private static final Integer MAXIMO = 5;
    /**
     * Numero minimo de elementos de la lista
     */
    private static final Integer NUM_MINIMO = 10;
    /**
     * Numero maximo de elementos de la lista
     */
    private static final Integer NUM_MAXIMO = 20;

    public static void main(String[] args) {

        List<Integer> listaNumeros = new ArrayList<>();
        generaLista(listaNumeros);
        ES.msg(pintaLista(listaNumeros));
        eliminaNumero(listaNumeros);
        
    }    

    /**
     * generador de numeros aleatorios
     * @return numero aleatorio
     */
    public static int generaAleatorios() {
        int nuevo = (int) (Math.random() * (MINIMO - MAXIMO) + MAXIMO + 1);
        return nuevo;
    }

    /**
     * Rellena la lista con los numeros aleatorios
     * @param listaNumeros lista para rellenar
     * @throws IllegalArgumentException 
     */
    public static void generaLista(List<Integer> listaNumeros) throws IllegalArgumentException {
        int tamanyo = ES.leeEntero("Introduce un número entre 10 y 20: ", NUM_MINIMO, NUM_MAXIMO);
        do {
            listaNumeros.add((Integer) generaAleatorios());
        } while (listaNumeros.size() < tamanyo);
    }

    /**
     * Metodo para mostrar la lista de numeros
     * @param listaNumeros lista que sera mostrada
     * @return mensaje con los numeros del conjunto
     */
    public static String pintaLista(List<Integer> listaNumeros) {
        StringBuilder lista = new StringBuilder();
        lista.append("*");
        for (Integer listaNumero : listaNumeros) {
            lista.append(listaNumero);
        }
        lista.append("*");
        return lista.toString();
    }
    
    /**
     * metodo para eliminar numeros de la lista
     * @param listaNumeros lista de la que se eliminaran numeros
     * @throws IllegalArgumentException 
     */
    public static void eliminaNumero(List<Integer> listaNumeros) throws IllegalArgumentException {
        do {
            Integer objetivo = ES.leeEntero("\nIntroduce el número a eliminar: ", MINIMO, MAXIMO);

            if (listaNumeros.contains(objetivo)) {
                for (int i = 0; listaNumeros.contains(objetivo); i++) {
                    if (Objects.equals(listaNumeros.get(i), objetivo)) {
                        listaNumeros.remove(listaNumeros.get(i));
                        i--;
                    }
                }
            }else{
                ES.msg("El número "+objetivo+" no está en la lista.");
            }

            ES.msg(pintaLista(listaNumeros));
        } while (listaNumeros.size() > 0);
        ES.msg("La lista esta vacia. Saliendo de la aplicacion.");
    }

}
