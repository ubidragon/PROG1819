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
 * <p>
 * Dada una variable entera <code>a</code> cuyo valor inicial es 2, y otra
 * variable entera <code>b</code> cuyo valor inicial es 3, haz que se muestre la
 * secuencia de resultados:<br>&nbsp; &nbsp;&nbsp; <code>false</code>,
 * <code>true</code>, <code>false</code>, <code>true</code>,
 * <code>false</code>&nbsp;&nbsp; (5 en total) usando un operador de relación
 * diferente en cada caso, tal y como se ha visto en el apartado 13.3 de la
 * unidad.</p>
 * <p>
 * &nbsp;</p>
 *
 *
 * @author Ubaldo Hidalgo Arriaga
 */
public class Actividad_4 {

    /**
     *
     *
     * @param args
     */
    public static void main(String[] args) {
        int a = 2;
        int b = 3;

        StringBuilder res = new StringBuilder("el resultado del ejercicio es: ");
        res.append("\n").append(3 < 2)
                .append(", ").append(3 > 2)
                .append(", ").append(a == b)
                .append(", ").append(a != b)
                .append(", ").append(a >= b);

        System.out.println(res);
    }
}
