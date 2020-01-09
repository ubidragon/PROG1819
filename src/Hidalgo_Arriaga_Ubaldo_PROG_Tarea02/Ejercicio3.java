/*
 * The MIT License
 *
 * Copyright 2018 Ubaldo Hidalgo Arriaga.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package Hidalgo_Arriaga_Ubaldo_PROG_Tarea02;

/**
 *
 * Pequeño programa para calcular el precio del uniforme en función de la etapa educativa y del genero del alumnado
 * @author Ubaldo Hidalgo Arriaga
 */
public class Ejercicio3 {

    /**
     * Tipo enumerado con las diferentes etapas educativas
     */
    public enum Curso {
        INFANTIL, PRIMARIA, SECUNDARIA, DESCONOCIDO
    }

    /**
     * Tipo enumerado con los diferentes generos.
     */
    public enum Para {
        NIÑO, NIÑA
    }

    /**
     * Lanzador de mensajes y de eleccion de cursos, generos y precios.
     * @param args 
     */
    
    public static void main(String[] args) {

        /*En este ejercicio realizo todo dentro del main porque se indica 
        explicitamente en el enunciado del ejercicio de la tarea2*/
        int edad = (int) Math.round(Math.random() * 20);
        int genero = (int) Math.round(Math.random());
        Curso curso= null;
        Para para = null;

        StringBuilder msg = new StringBuilder("Edad: ");
        msg.append(edad);
        msg.append("\nGenero: ").append(genero);
        
        /*
        Selector de curso en funcion de la edad.
        */
        switch (edad) {
            case 3:
            case 4:
            case 5:
                curso = Curso.INFANTIL;
                break;
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                curso = Curso.PRIMARIA;
                break;
            case 12:
            case 13:
            case 14:
            case 15:
                curso = Curso.SECUNDARIA;
                break;
            default:
                curso = Curso.DESCONOCIDO;
                break;
        }
        /*
        Selector de genero del alumn@
        */
        switch (genero) {
            case 0:
                para = Para.NIÑO;
                break;
            case 1:
                para = Para.NIÑA;
                break;
        }

        /*
        Estructura if/else usada para la eleccion de la etapa educativa
        */
        if (curso == Curso.INFANTIL) {
            msg.append("\nEl uniforme de ").append(curso).append(" para ").append(para).append(" vale 100.0€.");
        } else if (curso == Curso.PRIMARIA) {
            if (para == Para.NIÑA) {
                msg.append("\nEl uniforme de ").append(curso).append(" para ").append(para).append(" vale 124.0€.");
            } else {
                msg.append("\nEl uniforme de ").append(curso).append(" para ").append(para).append(" vale 126.0€.");
            }
        } else if (curso == Curso.SECUNDARIA) {
             msg.append("\nEl uniforme de ").append(curso).append(" para ").append(para).append(" vale 143.0€.");
        } else if (curso == Curso.DESCONOCIDO) {
            
            msg.append("\nEtapa educativa desconocida.");
        }

        System.out.println(msg.toString());
    }

}
