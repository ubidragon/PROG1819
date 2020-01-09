package Hidalgo_Arriaga_Ubaldo_PROG_Tarea01;

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
/**
 *
 * @author Ubaldo Hidalgo Arriaga
 */
public class Actividad_6 {

    /**
     * <p>
     * Para generar un número entre un número que deseemos y otro, podemos
     * usar:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
     * <code>*(num_minimo-num_maximo)+num_maximo</code>, por ejemplo:&nbsp;
     * <code>Math.random()*(5-20)+20</code>. <br>Genera un número entre -5 y 4 y
     * así, usando exclusivamente el operador condicional, junto con operadores
     * de relación, lógicos y de asignación, escribe un código en Java que
     * muestre por pantalla si el número aleatorio generado está entre los
     * rangos siguientes:</p>
     * <ul class="lista_verificacion">
     * <li>Entre -5 y 0, 0 no incluido.</li>
     * <li>Entre 0 y 2, ambos incluidos.</li>
     * <li>Entre 2 y 4, 2 no incluido.</li>
     * </ul>
     *
     * @param args
     */
    public static void main(String[] args) {
        int num_minimo = -5;
        int num_maximo = 4;
        int nuevo = (int) (Math.random() * (num_minimo - num_maximo) + num_maximo);

        StringBuilder res = new StringBuilder("numero minimo definido ==> ").append(num_minimo);
        res.append("\nnumero maximo definido ==> ").append(num_maximo);
        res.append("\nEl nuevo numero es: ").append(nuevo);
        res.append("\n¿El numero esta entre -5 y 0? ==> ").append(nuevo >= num_minimo && nuevo < 0 && nuevo != 0);
        res.append("\n¿El numero esta entre 0 y 2, ambos incluidos? ==> ").append(nuevo >= 0 && nuevo <= 2);
        res.append("\n¿El numero esta entre 2 y 4, 2 no incluido.? ==> ").append(nuevo > 2 && nuevo <= 4 && nuevo != 2);

        System.out.println(res);

    }
}
