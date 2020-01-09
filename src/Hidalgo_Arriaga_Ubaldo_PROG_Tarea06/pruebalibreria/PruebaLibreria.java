package Hidalgo_Arriaga_Ubaldo_PROG_Tarea06.pruebalibreria;

import java.util.Arrays;
import Hidalgo_Arriaga_Ubaldo_PROG_Tarea06.libreria.*;

/**
 * Clase de prueba de la biblioteca de clases libreria
 * @author profe
 */
public class PruebaLibreria {

    /**
     * Programa principal de prueba de la biblioteca libreria
     * @param args argumentos pasados a través del intérprete de órdenes (command line)
     */
    public static void main(String[] args) {
        final double ANCHO_BANDA= 100; // Ancho de banda del sistema: 100Kbytes/seg
        Producto[] listaProductos=  {null, null, null, null};
                
        //-------------------------------------------------------
        // Prueba de productos
        //-------------------------------------------------------
        Producto p;


        //-------------------------------------------------------
        // Creación de productos
        //-------------------------------------------------------
        System.out.println ("CREACIÓN DE PRODUCTOS");
        System.out.println ("---------------------");
        System.out.println ("Creando producto 0 con errores...");
        try {
            p= new LibroFisico ("Libro 1", 20.0, "Descripción L1", "Autor 1", 2018, 50000);
        } catch (IllegalArgumentException ex) {
            System.out.println ("Error al crear el producto 0: " + ex.getMessage());        
        }
        try {
            p= new LibroFisico ("Libro 1", 20.0, "Descripción L1", "Autor 1", 2018, 3);
        } catch (IllegalArgumentException ex) {
            System.out.println ("Error al crear el producto 0: " + ex.getMessage());        
        }
        System.out.println ("Creando producto 0 correctamente...");
        listaProductos[0]= new LibroFisico ("Libro 1", 20.0, "Descripción L1", "Autor 1", 2018, 250);
        System.out.println ("Creado Producto 0.");


        System.out.println();
        System.out.println ("Creando producto 1 con errores...");
        try {
            p= new LibroFisico ("Libro 2", 12.50, "Descripción L2", "Autor 2", 1499, 300);
        } catch (IllegalArgumentException ex) {
            System.out.println ("Error al crear el producto 1: " + ex.getMessage());        
        }
        try {
            p= new LibroFisico ("Libro 2", 12.50, "Descripción L2", "Autor 2", 2050, 300);
        } catch (IllegalArgumentException ex) {
            System.out.println ("Error al crear el producto 1: " + ex.getMessage());        
        }
        System.out.println ("Creando producto 1 correctamente...");        
        listaProductos[1]= new LibroFisico ("Libro 2", 12.50, "Descripción L2", "Autor 2", 1979, 300);
        System.out.println ("Creado Producto 1.");


        System.out.println();
        System.out.println ("Creando producto 2 con errores...");
        try {
            p= new LibroElectronico ("Libro 3", 42.99, "Descripción L3", "Autor 3", 2015, 80000);
        } catch (IllegalArgumentException ex) {
            System.out.println ("Error al crear el producto 2 " + ex.getMessage());        
        }
        try {
            p= new LibroElectronico ("Libro 3", 42.99, "Descripción L3", "Autor 3", 2015, 0);
        } catch (IllegalArgumentException ex) {
            System.out.println ("Error al crear el producto 2 " + ex.getMessage());        
        }
        System.out.println ("Creando producto 2 correctamente...");        
        listaProductos[2]= new LibroElectronico ("Libro 3", 42.99, "Descripción L3", "Autor 3", 2015, 1200);
        System.out.println ("Creado Producto 2.");


        System.out.println();
        System.out.println ("Creando producto 3 con errores...");
     /*   try {
            p= new EReader ("Kindle Paperwhite", 0, "Descripción KP", "Amazon");
        } catch (IllegalArgumentException ex) {
            System.out.println ("Error al crear el producto 3 " + ex.getMessage());        
        }
        try {
            p= new EReader ("Kindle Paperwhite", 90000, "Descripción KP", "Amazon");
        } catch (IllegalArgumentException ex) {
            System.out.println ("Error al crear el producto 3 " + ex.getMessage());        
        }
        System.out.println ("Creando producto 3 correctamente...");        
        listaProductos[3]= new EReader ("Kindle Paperwhite", 129.99, "Descripción KP", "Amazon");
        System.out.println ("Creado Producto 3.");
*/

        //-------------------------------------------------------
        // Visualización por pantalla de productos
        //-------------------------------------------------------
        System.out.println ();
        System.out.println ("PRODUCTOS CREADOS");
        System.out.println ("-----------------");
        for (int i=0; i<listaProductos.length; i++) {
            System.out.printf ("Producto %d: \n", i);
            mostrarContenidoElemento (listaProductos[i]);            
        }
        System.out.println ();
        
        //-------------------------------------------------------
        // Prueba de descarga de productos
        //-------------------------------------------------------
        System.out.println ();
        System.out.println ("PRUEBA DE DESCARGA DE PRODUCTOS");
        System.out.println ("------------------------------");
        for (int i=0; i<listaProductos.length; i++) {
            System.out.printf ("Intento de descarga del producto %d...\n", i);
            System.out.println ("Funcionará si se trata de un objeto que implementa la interfaz Donwloadable.");        
            try {
                double td= ((Downloadable)listaProductos[i]).descargar(0); // Ancho de banda no válido
            } catch (ClassCastException ex) {
                System.out.println ("Error al intentar descargar el producto: " + ex.getMessage());                    
            } catch (IllegalArgumentException ex) {
                System.out.println ("Error al intentar descargar el producto: " + ex.getMessage());                    
                System.out.println ("Nuevo intento con parámetro de ancho de banda compatible.");                    
                double td= ((Downloadable)listaProductos[i]).descargar(ANCHO_BANDA);
                System.out.println ("Descarga correcta");
                System.out.printf ("Tiempo de descarga del Producto %d: %7.2f segundos.\n", i, td);
            //    int numDescargas= ((LibroElectronico)listaProductos[i]).getNumDescargas();
             //   System.out.printf ("Número de descargas del producto hasta el momento: %d.\n", numDescargas);                            
            }
            System.out.println ();
        }


    }
    
    //---------------------------------------------------------------------
    // Método para mostrar en pantalla el contenido de un objeto Arrayable
    //---------------------------------------------------------------------
    /**
     * Muestra en pantalla el contenido de un objeto Arrayable.
     * Muestra en pantalla el nombre y el valor de cada uno de los atributos de un objeto Arrayable que se pase como parámetro.
     * Hace uso de los métodos <code>toArrayAtribNames()</code> y 
     * <code>toArrayAtribValues()</code> que debe implementar toda clase Arrayable.
     * @param elemento Objeto Arrayable cuyo contenido se quiere mostrar en pantalla
     */
    public static void mostrarContenidoElemento (Arrayable elemento) {
        // Para que este fragmento de código funcione el objeto "elemento" debe
        // implementar la interfaz "Arrayable" que incluye los métodos 
        // toArrayAtribNames y toArrayAtribValues

        // Obtenemos el tipo de objeto (nombre de la clase)
        System.out.println ("Tipo de objeto: " + elemento.getClass().getName());
        // Obtenemos los arrays de nombres de atributos y valores de atributos
        String[] nombresAtributos= elemento.toArrayAtribNames();
        String[] valoresAtributos= elemento.toArrayAtribValues();
        // Mostramos el contenido de ambos arrays
        System.out.println ("Nombres de los atributos: " + Arrays.toString(nombresAtributos));
        System.out.println ("Valores de los atributos: " + Arrays.toString(valoresAtributos));
    }

/*
 Forma de hacerlo "manualmente", sin Arrays.toString():
            // Recorremos el array de nombres de atributos
        StringBuilder stringNombresAtributos= new StringBuilder();
        stringNombresAtributos.append ("{");
        for (String atributo : nombresAtributos) {
            stringNombresAtributos.append(atributo).append(" ");
        }
        stringNombresAtributos.append ("]");
        // Recorremos el array de valores de atributos
        StringBuilder stringValoresAtributos= new StringBuilder();
        stringValoresAtributos.append ("{");
        for (String atributo : valoresAtributos) {
            stringValoresAtributos.append(atributo).append(" ");
        }
        stringValoresAtributos.append ("}");

    
    */
    
}
