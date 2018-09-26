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
 * crea ahora un pequeño programa que defina un enumerado con los sistemas
 * <p>
 * Al igual que en el apartado 11.4 de la unidad se definen unidades de medida
 * de volumen, crea ahora un pequeño programa que defina un enumerado con los
 * sistemas operativos: <strong>IOS</strong>, <strong>LINUX</strong>
 * y <strong>WINDOWS</strong>, para posteriormente mostrar por pantalla cada va
 *
 * @author Ubaldo Hidalgo Arriaga
 */
public class Actividad_1 {

    public enum OperativeSystem {
        IOS, LINUX, WINDOWS
    }

    /**
     * lor del enumerado declarado.</span></p>
     *
     * @param args
     */
    public static void main(String[] args) {

        System.out.println(OperativeSystem.IOS);
        System.out.println(OperativeSystem.LINUX);
        System.out.println(OperativeSystem.WINDOWS);

    }
}
