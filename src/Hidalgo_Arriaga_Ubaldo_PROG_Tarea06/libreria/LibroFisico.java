/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hidalgo_Arriaga_Ubaldo_PROG_Tarea06.libreria;

/**
 *
 * Clase que representa un producto de tipo Libro Físico para la gestión de
 * productos en una tienda. Los objetos de esta clase contienen atributos que
 * permiten almacenar toda la información relativa a un producto de tipo libro
 * físico (no electrónico) en una tienda. Además de los atributos propios de un
 * libro en abstracto, deberá contener los específicos de un libro físico, que
 * son:
 *
 * Número de páginas del libro.
 *
 * @author ubidragon
 */
public class LibroFisico extends Libro {

    private int numPaginas;
    /**
     * Mínimo número de páginas permitido.
     */
    public static int MIN_PAGINAS = 20;
    /**
     * Máximo número de páginas permitido.
     */
    public static int MAX_PAGINAS = 5000;

    /**
     * Crea un objeto LibroFisico con un nombre, precio, texto de descripción, autor, año de edición y número de páginas.
     * @param nombre Título del libro
     * @param precio Precio del libro
     * @param descripcion Descripción del libro
     * @param autor  Autor del libro
     * @param year Año de edición del libro
     * @param numPaginas Número de páginas del libro
     * @throws IllegalArgumentException si alguno de los parámetros no es válido
     */
    public LibroFisico(String nombre, double precio, String descripcion, String autor, int year, int numPaginas) throws IllegalArgumentException {
        super(nombre, precio, descripcion, autor, year);
        checkPaginas(numPaginas);
        this.numPaginas = numPaginas;
    }

    /**
     * Devuelve el número de páginas del libro
     * @return número de páginas del libro
     */
    public int getNumPaginas() {
        return numPaginas;
    }

    private void checkPaginas(int paginas) {
        if (paginas < MIN_PAGINAS || paginas > MAX_PAGINAS) {
            throw new IllegalArgumentException("Error: Parámetros de creación del libro físico inválidos. El número de páginas " + paginas + " no está en el rango permitido");
        }
    }

    @Override
    public String[] toArrayAtribNames() {
        String[] res = new String[]{super.toArrayAtribNames()[0], super.toArrayAtribNames()[1],
            super.toArrayAtribNames()[2], super.toArrayAtribNames()[3], super.toArrayAtribNames()[4],
            "numero de paginas"};

        return res;
    }

    @Override
    public String[] toArrayAtribValues() {

        String[] res = new String[]{super.toArrayAtribValues()[0], super.toArrayAtribValues()[1],
            super.toArrayAtribValues()[2], super.toArrayAtribValues()[3], super.toArrayAtribValues()[4],
            Integer.toString(getNumPaginas())};

        return res;
    }

}
