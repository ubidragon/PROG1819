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
public class Ejercicio1 {
    

public static void main (String[] m)
    {
        int j=(int)Math.round(Math.random()*4+2); 
        int i=0;        
        int x=0;
        String mensaje="Caso "+j+": Hola en ";
        while (x<=j) {
            i+=x;
            x++;
        }        
        
        switch(i)
        {
            case 3: 
                mensaje+="Suajili se pronuncia 'jambo'.";
                break;
            case 6: 
                mensaje+="Ruso se pronuncia 'pri-viet'.";
                break;
            case 10: 
                mensaje+="Árabe se pronuncia \"As-salām 'alaykum\".";
                break;             
            case 15:
                mensaje+="Chino se pronuncia 'ni hao'.";
                break;                 
            case 21:
                mensaje+="Japonés se pronuncia 'ko-nin-chi-wá'.";
                break; 
            case 28:
                mensaje+="Hebreo se pronuncia 'shalom'.";
                break; 
        }
        
        System.out.println(mensaje);
    }


}
