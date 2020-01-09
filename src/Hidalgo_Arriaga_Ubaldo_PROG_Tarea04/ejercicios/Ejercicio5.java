/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hidalgo_Arriaga_Ubaldo_PROG_Tarea04.ejercicios;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import Hidalgo_Arriaga_Ubaldo_PROG_Tarea04.utilidades.ES;

/**
 *
 * Ejercicio para determinar el tipo de matricula pasada por el usuario.
 *
 * @author Ubaldo Hidalgo Arriaga
 */
public class Ejercicio5 {

    public static void main(String[] args) {
        StringBuilder msg = new StringBuilder();

        String[] europeo = new String[5];
        String[] antiguo = new String[5];
        String[] muyAntiguo = new String[5];

        while (europeo[europeo.length - 1] == null && antiguo[antiguo.length - 1] == null && muyAntiguo[muyAntiguo.length - 1] == null) {
            msg.append("Escribe la matrícula: ");
            System.out.println(msg.toString());
            msg.delete(0, msg.length());
            msg.append(ES.leeCadena());
            comprobarPatron(msg, europeo, antiguo, muyAntiguo);
            msg.delete(0, msg.length());
        }

        generaListadoMatriculas(msg, muyAntiguo, antiguo, europeo);
        System.out.println(msg.toString());

    }

    /**
     * Metodo auxiliar para generar los listados de matriculas de cada conjunto
     *
     * @param msg variable para almacenar el texto a mostrar al usuario
     * @param muyAntiguo conjunto de matriculas muy antiguas
     * @param antiguo conjunto de matriculas antiguas
     * @param europeo conjunto de matriculas europeas
     */
    private static void generaListadoMatriculas(StringBuilder msg, String[] muyAntiguo, String[] antiguo, String[] europeo) {
        msg.append("\nMatrículas con formato muy antiguo:");
        for (String matricula : muyAntiguo) {
            if (matricula != null) {
                msg.append(matricula).append(" ");
            }
        }
        msg.append("\nMatrículas con formato antiguo: ");
        for (String matricula : antiguo) {
            if (matricula != null) {
                msg.append(matricula).append(" ");
            }
        }
        msg.append("\nMatrículas con formato europeo: ");
        for (String matricula : europeo) {

            if (matricula != null) {
                msg.append(matricula).append(" ");
            }
        }
    }

    /**
     *
     * Metodo para determinar que tipo de matricula es introducida por el
     * usuario.
     *
     * @param msg matricula introducida por el usuario
     * @param muyAntiguo conjunto de matriculas muy antiguas
     * @param antiguo conjunto de matriculas antiguas
     * @param europeo conjunto de matriculas europeas
     */
    private static void comprobarPatron(StringBuilder msg, String[] europeo, String[] antiguo, String[] muyAntiguo) {
        Matcher m = Pattern.compile("E([0-9]){4}([A-Z]){3}$").matcher(msg.toString());

        if (m.matches()) {
            int i = 0;
            while (europeo[i] != null) {
                i++;
            }
            europeo[i] = msg.toString();
            System.out.println("La matrícula tiene el formato europeo");
        } else if (m.usePattern(Pattern.compile("^([A-Z]){2}([0-9]){4}([A-Z]){2}$")).matches()) {
            int i = 0;
            while (antiguo[i] != null) {
                i++;
            }
            antiguo[i] = msg.toString();
            System.out.println("La matrícula tiene el formato antiguo");
        } else if (m.usePattern(Pattern.compile("^([A-Z]){2}([0-9]){6}$")).matches()) {
            int i = 0;
            while (muyAntiguo[i] != null) {
                i++;
            }
            muyAntiguo[i] = msg.toString();
            System.out.println("La matrícula tiene el formato muy antiguo");
        } else {
            System.out.println("Matrícula incorrecta");
        }
    }
}
