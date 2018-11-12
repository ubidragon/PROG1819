package Hidalgo_Arriaga_Ubaldo_PROG_Tarea03.formas;

import Hidalgo_Arriaga_Ubaldo_PROG_Tarea03.utilidades.ES;

/**
 * Clase principal del programa, que consiste en un bucle que estar� iterando
 * continuamente mientras que el usuario no introduzca un 0.
 *
 * @author
 */
public class Principal {

    /**
     * Variable global para generar los mensajes de usuario
     */
    public static StringBuilder message = new StringBuilder();

    public static int columnas, filas, color;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        consultaDatos();
    }

    public static void consultaDatos() {

        message.append("Vamos a crear un primer rectángulo.\n");

        peticionDatos("columna");
        peticionDatos("fila");
        peticionDatos("color");

        menu();

    }

    public static void menu() {
        boolean parada = true;
        Rectangulo rectangulo = new Rectangulo('*', filas, columnas, Rectangulo.enteroAcolor(color));
        while (parada) {
            eliminaMensaje();

            message.append("========================================\n")
                    .append("============== Rectángulos =============\n")
                    .append("========================================\n\n")
                    .append("1.- Mostrar los datos del rectángulo.\n")
                    .append("2.- Dibujar rectángulo.\n")
                    .append("3.- Dibujar rectángulo relleno.\n")
                    .append("4.- Modificar altura (filas) del rectángulo.\n")
                    .append("5.- Modificar anchura (columnas) del rectángulo.\n")
                    .append("6.- Girar rectángulo.\n")
                    .append("7.- Modificar color del rectángulo.\n")
                    .append("8.- Dibujar tres rectángulos: el primero relleno el segundo solo con borde y el tercero relleno.\n")
                    .append("9.- Dibujar dos rectángulos e interambiar (usando los sets y los gets) las filas y columnas de uno al otro.\n\n")
                    .append("0.- Salir de la aplicación.\n")
                    .append("========================================\n")
                    .append("Introduzca la opción elegida: ");
            ES.msgln(message.toString() + "\n");

            int opciones = ES.leeEntero();

            switch (opciones) {
                case 1:
                    ES.msgln(rectangulo.toString() + "\n");
                    break;
                case 2:
                    ES.msgln(rectangulo.dibujar2D(false));
                    break;
                case 3:
                    ES.msgln(rectangulo.dibujar2D(true));
                    break;
                case 4:
                    opcionModificarAltura(ES.leeEntero(), rectangulo);
                    break;
                case 5:
                    opcionModificarAnchura(ES.leeEntero(), rectangulo);
                    break;
                case 6:
                    rectangulo.girarRectangulo();
                    ES.msgln("Rectángulo girado");
                    break;
                case 7:
                    peticionDatos("color");
                    rectangulo.setColor(Rectangulo.enteroAcolor(color));
                    ES.msgln("Color cambiado.");
                    break;
                case 8:
                    eliminaMensaje();
                    Rectangulo primero = new Rectangulo();
                    Rectangulo segundo = new Rectangulo();
                    Rectangulo tercero = new Rectangulo();
                    ES.msgln(tresRectangulos(primero, 6, 13, '@', true));
                    ES.msgln(tresRectangulos(segundo, 10, 12, '/', false));
                    ES.msgln(tresRectangulos(tercero, 3, 7, '$', true));
                  
                    break;
                case 9:
                    eliminaMensaje();
                    Rectangulo rectanguloPenultimo = new Rectangulo('@', 7, 4, Rectangulo.enteroAcolor(color));
                    Rectangulo rectanguloUltimo = new Rectangulo('/', 5, 10, Rectangulo.enteroAcolor(color));
                    message.append("Primero dibujamos un rectángulo de 7 filas y 4 columnas\n");
                    message.append(rectanguloPenultimo.dibujar2D(true));
                    message.append("Y ahora un rectángulo de 5 filas y 10 columnas\n");
                    message.append(rectanguloUltimo.dibujar2D(false));
                    rectanguloPenultimo.setFilas(5);
                    rectanguloPenultimo.setColumnas(10);
                    rectanguloUltimo.setFilas(7);
                    rectanguloUltimo.setColumnas(4);
                    message.append("Ahora, cambiamos con los sets los valores de "
                            + "filas y columnas del primer rectángulo con los del segundo"
                            + "\nY así el primer rectángulo queda ahora:\n");
                    message.append(rectanguloPenultimo.dibujar2D(true));
                    message.append("Y el segundo rectángulo queda como:\n");
                    message.append(rectanguloUltimo.dibujar2D(false));
                    ES.msgln(message.toString());
                    break;
                case 0:
                    parada = false;
                    break;
            }

        }
    }

    /**
     * Metodo para pintar los 3 rectangulos de la opcion 8
     *
     * @param rectangulo objeto que vamos a modificar
     * @param filas filas que vamos tener
     * @param columnas columnas que vamos a tener
     * @param caracter caracter que usaremos
     * @param relleno opcion para saber si sera relleno o no.
     */
    public static String tresRectangulos(Rectangulo rectangulo, int filas, int columnas, Character caracter, boolean relleno) {
        eliminaMensaje();
        rectangulo.setColumnas(columnas);
        rectangulo.setFilas(filas);
        rectangulo.setCaracter(caracter);
        message.append(rectangulo.dibujar2D(relleno)).append("\n");
        return message.toString();
    }

    /**
     * metodo para la opcion de modificar la anchura del rectangulo
     *
     * @param medida lectura de cuanto se quiere incrementar o decrementar el
     * rectangulo
     * @param rectangulo objeto el cual se modificara
     */
    public static void opcionModificarAnchura(int medida, Rectangulo rectangulo) {

        ES.msgln("Escriba un número entre -10 y 10 para aumentar la anchura del rectángulo en ese tamaño: ");

        if (medida <= 10 || medida >= -10) {
            rectangulo.modificarAnchura(medida);
            ES.msgln("Anchura modificada correctamente.");
        } else {
            ES.msgln("No fue posible modificar la anchura.");
        }
    }

    /**
     * metodo para la opcion de modificar la altura del rectangulo
     *
     * @param medida lectura de cuanto se quiere incrementar o decrementar el
     * rectangulo
     * @param rectangulo objeto el cual se modificara
     */
    public static void opcionModificarAltura(int medida, Rectangulo rectangulo) {
        ES.msgln("Escriba un número entre -10 y 10 para aumentar la altura del rectángulo en ese tamaño: ");

        if (medida <= 10 || medida >= -10) {
            rectangulo.modificarAltura(medida);
            ES.msgln("Altura modificada correctamente.");
        } else {
            ES.msgln("No fue posible modificar la altura.");
        }
    }

    /**
     * Metodo para pedir datos al usuario
     *
     * @param tipo tipo de dato que se ha pedido
     * 
     */
    public static void peticionDatos(String tipo) {
        boolean parada = true;
        while (parada) {
            eliminaMensaje();
            switch (tipo) {
                case "columna":
                    message.append("Escribe el número de columnas que tendrá el rectángulo (entre 1 y 80)");
                    ES.msgln(message.toString());
                    columnas = ES.leeEntero(1, 80);
                    if (columnas != 0) {
                        parada = false;
                    }
                    break;
                case "fila":
                    message.append("Escribe el número de filas que tendrá el rectángulo(entre 1 y 40)");
                    ES.msgln(message.toString());
                    filas = ES.leeEntero(1, 40);
                    if (filas != 0) {
                        parada = false;
                    }
                    break;
                case "color":
                    message.append("Escriba el color del rectángulo (1-> ROJO, 2-> NEGRO, 3-> BLANCO, 4-> AMARILLO)");
                    ES.msgln(message.toString());
                    color = ES.leeEntero(1, 4);
                    if (color != 0) {
                        parada = false;
                    }
                    break;

            }

        }
    }

    /**
     * Metodo privado que se utilizara para eliminar todo el contenido de un
     * StringBuilder
     */
    public static void eliminaMensaje() {
        message.delete(0, message.length());
    }
}
