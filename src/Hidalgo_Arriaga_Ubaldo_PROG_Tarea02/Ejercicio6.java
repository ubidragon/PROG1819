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
 * @author Ubaldo Hidalgo Arriaga
 */
public class Ejercicio6 {

    public static void main(String[] args) {

        boolean parada = true;
        int posicionX1, posicionX2, posicionY1, posicionY2;
        StringBuilder message = new StringBuilder();

        posicionX1 = (int) (Math.random() * 5);
        posicionY1 = (int) (Math.random() * 5);

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

        for (int i = 0; i < 5; i++) {

            message.append(i).append(" ");
            
          
                for (int j = 0; j < 5; j++) {
                    if ((posicionY1==j && posicionX1 == i)  || (posicionY2==j && posicionX2 == i)) {
                        message.append("*");
                    } else {
                        message.append("-");
                    }
                }
        
            for (int j = 0; j < 5; j++) {

            }

            message.append(" \n");

        }

        System.out.println(message.toString());
    }

}
