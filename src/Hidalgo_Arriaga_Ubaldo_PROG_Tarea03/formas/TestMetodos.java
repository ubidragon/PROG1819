package Hidalgo_Arriaga_Ubaldo_PROG_Tarea03.formas;

import static Hidalgo_Arriaga_Ubaldo_PROG_Tarea03.formas.Principal.color;
import static Hidalgo_Arriaga_Ubaldo_PROG_Tarea03.formas.Principal.message;
import static Hidalgo_Arriaga_Ubaldo_PROG_Tarea03.formas.Principal.tresRectangulos;
import Hidalgo_Arriaga_Ubaldo_PROG_Tarea03.formas.Rectangulo.Color;
import Hidalgo_Arriaga_Ubaldo_PROG_Tarea03.utilidades.ES;

/**
 * Clase para probar el funcionamiento de los m�todos realizando operaciones
 *
 * @author
 */
public class TestMetodos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IllegalArgumentException {

        ES.msgln("Intento crear un rect�ngulo de 0 filas y 3 columnas");
        try {
            Rectangulo rectangulo = new Rectangulo('#', 0, 3, Color.ROJO);

        } catch (Exception e) {

            ES.msgln(e.toString());

        }
        Rectangulo rectangulo2 = new Rectangulo('#', 6, 10, Color.VERDE);
        ES.msgln("Mostramos los datos de el rect�ngulo: \n" + rectangulo2.toString());
        ES.msgln("Dibujamos el rect�ngulo (sin relleno):");
        ES.msgln(rectangulo2.dibujar2D(false));
        ES.msgln("Dibujamos el rect�ngulo (relleno):");
        ES.msgln(rectangulo2.dibujar2D(true));

        ES.msgln("Volver a dibujar el rect�ngulo (sin relleno):");
        rectangulo2.setFilas(26);
        ES.msgln(rectangulo2.dibujar2D(false));
        ES.msgln("Volver a dibujar el rect�ngulo (sin relleno):");
        rectangulo2.setColumnas(30);
        ES.msgln(rectangulo2.dibujar2D(false));
        ES.msgln("Rect�ngulo girado");
        rectangulo2.girarRectangulo();
        ES.msgln(rectangulo2.dibujar2D(false));
        ES.msgln("Color cambiado.");
        rectangulo2.setColor(Color.AMARILLO);
        ES.msgln("Mostramos los datos de el rect�ngulo: \n" + rectangulo2.toString());
        Rectangulo primero = new Rectangulo();
        Rectangulo segundo = new Rectangulo();
        Rectangulo tercero = new Rectangulo();
        ES.msgln(tresRectangulos(primero, 6, 13, '@', true));
        ES.msgln(tresRectangulos(segundo, 10, 12, '/', false));
        ES.msgln(tresRectangulos(tercero, 3, 7, '$', true));

        Rectangulo rectanguloPenultimo = new Rectangulo('@', 7, 4, Rectangulo.enteroAcolor(color));
        Rectangulo rectanguloUltimo = new Rectangulo('/', 5, 10, Rectangulo.enteroAcolor(color));
        ES.msgln("Primero dibujamos un rectángulo de 7 filas y 4 columnas\n");
        ES.msgln(rectanguloPenultimo.dibujar2D(true));
        ES.msgln("Y ahora un rectángulo de 5 filas y 10 columnas\n");
        ES.msgln(rectanguloUltimo.dibujar2D(false));
        rectanguloPenultimo.setFilas(5);
        rectanguloPenultimo.setColumnas(10);
        rectanguloUltimo.setFilas(7);
        rectanguloUltimo.setColumnas(4);
        ES.msgln("Ahora, cambiamos con los sets los valores de "
                + "filas y columnas del primer rectángulo con los del segundo"
                + "\nY así el primer rectángulo queda ahora:\n");
        ES.msgln(rectanguloPenultimo.dibujar2D(true));
        ES.msgln("Y el segundo rectángulo queda como:\n");
        ES.msgln(rectanguloUltimo.dibujar2D(false));
        
        ES.msgln("");
        ES.msgln("");

    }

}
