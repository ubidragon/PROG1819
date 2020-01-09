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
 *
 * En un concurso de televisión, donde hay un total de 25 participantes
 * dispuestos en 5 columnas y 5 filas, se van eligiendo los participantes de 2
 * en 2 para competir entre sí. <br>Para facilitar la tarea de la presentadora,
 * te piden que hagas un programa que automatice la elección de los
 * participantes
 *
 * @author Ubaldo Hidalgo Arriaga
 */
public class Ejercicio6 {

    public static void main(String[] args) {

        boolean parada = true;
        int posicionX1, posicionX2, posicionY1, posicionY2;
        StringBuilder message = new StringBuilder();

        posicionX1 = (int) (Math.random() * 5);
        posicionY1 = (int) (Math.random() * 5);

        /*
        Bucle para la generacion de la posicion del siguiente participante, 
        dicho bucle se repite hasta que las coordenadas del participante sea difentes a las del primero
         */
        do {
            posicionX2 = (int) (Math.random() * 5);
            posicionY2 = (int) (Math.random() * 5);

            if (posicionX1 != posicionX2 && posicionY1 != posicionY2) {
                parada = false;
            }

        } while (parada);

        message.append("La primera mesa elegida es columna ").append(posicionY1).append(" , fila ").append(posicionX1);
        message.append("\nLa segunda mesa elegida es columna ").append(posicionY2).append(" , fila ").append(posicionX2);

        message.append("\n  01234\n");

        /*
        Primer bucle que se encarga de pintar las filas
         */
        for (int i = 0; i < 5; i++) {

            message.append(i).append(" ");
            /*
            Segundo bucle que se encarga de pintar cada columna de cada fila y
            filtra donde debe de colocar el * del participante
             */
            for (int j = 0; j < 5; j++) {
                if ((posicionY1 == j && posicionX1 == i) || (posicionY2 == j && posicionX2 == i)) {
                    message.append("*");
                } else {
                    message.append("-");
                }
            }

            message.append(" \n");

        }

        System.out.println(message.toString());
    }

}
