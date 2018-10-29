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
 * Generador de flechas a los laterales de asteriscos generados aleatoriamente.<br>
 * Posibles patrones:<br>
 * {@literal >>>>***<<<}<br>
 * {@literal >>>>**<<<<}
 * 
 * @author Ubaldo Hidalgo Arriaga
 */
public class Ejercicio4 {

    static final int MAX_LONGITUD = 10;

    public static void main(String[] args) {
       
        lanzador();
    }

    private static void lanzador() {

                
                int asteriscos = (int)Math.round(Math.random()*5);
               
                    int derecha = (MAX_LONGITUD - asteriscos) / 2;
                
                    int izquierda = (MAX_LONGITUD - asteriscos) - derecha;

                    System.out.println(laterales(derecha, izquierda, asteriscos));
                    

    }

    /*
    Realmente se podria diseñar un unico metodo que pintase un lado u otro y ahorrariamos ineas de codigo.
     */
 /*
    Hemos usado los do-while en la generacion de los laterales ya que, 
    excepto que se introduzca como valor de asteriscos 10, siempre se ejecutaran
    almenos una vez.
     */
    private static String laterales(int derecha, int izquierda, int centro) {
        StringBuilder lateral = new StringBuilder();
        lateral.append("El numero de asteriscos es: ").append(centro).append("\n");
        int contador = 0;
        do {
            lateral.append(">");

            contador++;
        } while (contador < izquierda);
        contador = 0;
        lateral.append(centro(contador, centro));
        contador = 0;
        do {
            lateral.append("<");

            contador++;
        } while (contador < derecha);

        return lateral.toString();
    }

    private static String centro(int contador, int centro) {
        StringBuilder central = new StringBuilder();

        while (contador < centro) {
            central.append("*");
            contador++;
        }

        return central.toString();
    }

}
