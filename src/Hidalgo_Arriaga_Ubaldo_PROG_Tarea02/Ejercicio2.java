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
 * Programa generador de estado del clima en las ciudades de Varsovia o Budapest
 * 
 * @author Ubaldo Hidalgo Arriaga
 */
public class Ejercicio2 {

    final static int CONSTANTE = 4;

    public static void main(String[] args) {

        System.out.println(textMessage().toString());
    }

    /*
    Metodo auxiliar para la seleccion de la ciudad de la que se mstrara el estado del clima
    */
    private static StringBuilder selectCity(double ale) {
        StringBuilder city = new StringBuilder();
        if (ale >= CONSTANTE) {
            city.append("Varsovia");
        } else {
            city.append("Budapest");
        }

        return city;
    }

    /*
    Metodo auxiliar para la eleccion del estado del clima
    */
    private static StringBuilder selectWeather(double ale) {
        StringBuilder weather = new StringBuilder();

        if (ale >= 0 && ale < 4) {
            weather.append(" y hacía frio.");

        } else if (ale >= 4 && ale <= 8) {
            weather.append(" y hacía calor.");
        } else {
            weather.append(" y estaba nublado.");
        }

        return weather;

    }

    /*
    Metodo auxiliar para generar los textos que leera el usuario del programa
    */
    private static StringBuilder textMessage() {
        double ale = Math.random() * (15 - (-5)) + (-5);
        StringBuilder res = new StringBuilder("El primer número aleatorio es: ");
        StringBuilder aux = new StringBuilder("\nEstuve en ");
        res.append(ale);
        aux.append(selectCity(ale));
        ale = Math.random() * (12 - (-0)) + (-0);
        res.append("\nEl segundo número aleatorio es: ");
        res.append(ale);
        aux.append(selectWeather(ale));

        res.append(aux);
        
        return res;
    }

}
