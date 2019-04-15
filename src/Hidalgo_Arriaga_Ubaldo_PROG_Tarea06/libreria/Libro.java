/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria;

import java.time.LocalDate;

/**
 *
 * Clase abstracta que representa un producto de tipo Libro para la gestión de productos en una tienda.
Los objetos de esta clase contienen atributos que permiten almacenar la información relativa a un producto de tipo Libro en una tienda. Además de los atributos propios de un producto, deberá contener los específicos de un libro, que son:

Autor del libro.
Año de edición del libro.
Se trata de una clase abastracta que contiene la información mínima sobre el libro pero no contiene información que depende de su formato físico (si se trata de un libro en papel o un libro electrónico). Para eso existen otras clases especializadas que heredarán de ésta.


 * @author ubidragon
 */
public abstract class Libro extends Producto {

    /**
     * Autor del libro
     */
    protected String autor;
    /**
     * Mínimo año de edición permitido.
     */
    public static int MIN_YEAR = 1500;
    /**
     * Año de edición del libro
     */
    protected int year;

    /**
     * 
     * Crea un objeto Libro con un nombre, precio, un texto de descripción y autor.
     * @param nombre Título del libro
     * @param precio Precio del libro
     * @param descripcion Descripción del libro
     * @param autor Autor del libro
     * @param year Año de edición del libro
     * @throws java.lang.IllegalArgumentException  si alguno de los parámetros no es válido
     */
    public Libro(String nombre, double precio, String descripcion, String autor, int year) throws java.lang.IllegalArgumentException {
        super(descripcion, nombre, precio);
        checkDate(year);
        this.autor = autor;
        this.year = year;
    }

    /**
     * Devuelve el nombre del autor del libro
     * @return autor
     */
    public String getAutor() {
        return autor;
    }

    /**
     * Devuelve el año de publicación del libro
     * @return año de publicación

     */
    public int getYear() {
        return year;
    }

    private void checkDate(int year) {
        if (year < MIN_YEAR || year > LocalDate.now().getYear()) {
            throw new IllegalArgumentException("Error: Parámetros de creación del libro inválidos. El año de edición " + year + " no está en el rango permitido");
        }
    }


    @Override
    public String[] toArrayAtribNames() {
        String[] res = new String[]{super.toArrayAtribNames()[0], super.toArrayAtribNames()[1], super.toArrayAtribNames()[2], "autor", "año"};

        return res;
    }


    @Override
    public String[] toArrayAtribValues() {
        
        String[] res = new String[]{super.toArrayAtribValues()[0], super.toArrayAtribValues()[1], super.toArrayAtribValues()[2], getAutor(), Integer.toString(getYear())};

        return res;
    }

}
