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
 * Un maestro de matemáticas te ha pedido que realices un programa que genere
 * una serie de mini-tarjetas para trabajar en clase con su alumnado de 1º de
 * Primaria. <br>La idea es que se le entregue la primera tarjeta (que corresponde
 * con la primera línea recortada), y que el alumnado tenga que buscar las
 * tarjetas que correspondan en otras mesas (que serían las otras líneas
 * recortadas).
 *
 * @author Ubaldo Hidalgo Arriaga
 */
public class Ejercicio5 {

    public static void main(String[] args) {

        int x = (int) (Math.random() * 10 + 10);

        StringBuilder message = new StringBuilder();

        //Bucle ocultador del numero aleatorio
        for (int i = 10; i <= 19; i++) {
            message.append(" ");
            if (x == i) {
                message.append("**");
            } else {
                message.append(i);
            }

        }

        message.append("\n");
        //bucle ocultador de numeros excepto el elegido
        for (int i = 10; i <= 19; i++) {
            message.append("-");
            if (x != i) {
                message.append("--");
            } else {
                message.append(i);
            }

        }
        message.append("> Aquí va el ").append(x);

        message.append("\nLos 5 números posteriores son: ");
        //Bucle de los 5 siguientes
        for (int i = x + 1; i <= x + 5; i++) {
            message.append(i).append(" ");

        }
        message.append("\nLos 5 números anteriores son: ");
        //Bucle de los 5 anteriores
        for (int i = x - 1; i >= x - 5; i--) {
            message.append(i).append(" ");
        }

        System.out.println(message);
    }

}
