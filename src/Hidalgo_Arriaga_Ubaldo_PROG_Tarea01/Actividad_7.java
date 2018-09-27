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
 * Dada la variable <code>a</code> de tipo <code>double</code> inicializada a 6
 * y la variable <code>b</code> también de tipo <code>double</code> inicializada
 * a 8, realiza las siguientes operaciones aritméticas y muestra el resultado
 * por pantalla (muestra también el valor inicial de ambas variables tras
 * inicializarlas):</p>
 * <ul class="lista_verificacion">
 * <li>Restar 5 al doble de <code>a</code>.</li>
 * <li>Sumamos 3 a <code>a</code> y dividimos por 3, a todo ello sumamos&nbsp;
 * el doble de <code>b</code></li>
 * <li>Restar al triple de a un octavo de <code>b</code>.</li>
 * </ul>
 *
 * @author Ubaldo Hidalgo Arriaga
 */
public class Actividad_7 {

    /**
     *
     *
     * @param args
     */
    public static void main(String[] args) {
        double a = 6;
        double b = 8;
        StringBuilder res = new StringBuilder("Los valores iniciales de las variables son a = ").append(a).append(", y de b = ").append(b);
        res.append("\nRestar 5 al doble de a => ").append((a*2)-5);
        res.append("\nSumamos 3 a a y dividimos por 3, a todo ello sumamos  el doble de b => ").append(((3+a)/3)+2*b);
        res.append("\nRestar al triple de a un octavo de b. => ").append((3*a)-(b/8));
        System.out.println(res);
        
        
    }
}
