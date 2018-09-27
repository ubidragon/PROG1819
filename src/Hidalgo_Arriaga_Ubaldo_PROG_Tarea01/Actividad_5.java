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
 * * <p>
 * Dadas las variables siguientes: dos de tipo carácter (que puedes nombrar como
 * <code>z</code> y <code>t</code>) con valores 'A' y&nbsp; 'B', y dos enteras
 * (que puedes nombrar <code>x</code> e <code>y</code>) con valores 2 y 2
 * respectivamente.<br>Crea una expresión lógica, que utilice operadores lógicos
 * y relacionales, para cada uno de los siguientes casos (intenta evaluar
 * mentalmente el resultado de la expresión antes de mostrarlo por
 * pantalla):</p>
 * <ul class="lista_verificacion">
 * <li>x es mayor que y y z no es igual a t.</li>
 * <li>'F' es distinto de z y x es menor que 100</li>
 * <li>t es anterior alfabéticamente a
 * z&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
 * </ul>
 *
 * @author Ubaldo Hidalgo Arriaga
 */
public class Actividad_5 {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {

        char z = 'A';
        char t = 'B';
        int x = 2;
        int y = 2;
        
        StringBuilder res = new StringBuilder("x es mayor que y y z no es igual a t. ==> ").append(x>y && z != t);
        res.append("\n'F' es distinto de z y x es menor que 100 ==> ").append('F' != z && x < 100);
        res.append("\nt es anterior alfabéticamente a z ==> ").append(t<z);
        System.out.println(res);

    }
}
