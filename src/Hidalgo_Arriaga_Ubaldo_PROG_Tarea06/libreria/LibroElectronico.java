/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria;

/**
 *
 * Clase que representa un producto de tipo Libro Electrónico para la gestión de
 * productos en una tienda. Los objetos de esta clase contienen atributos que
 * permiten almacenar toda la información relativa a un producto de tipo libro
 * electrónico (ebook) en una tienda online. Además de los atributos propios de
 * un libro en abstracto, deberá contener los específicos de un libro
 * electrónico, que son:
 *
 * Tamaño del archivo (en kilobytes). Número de veces que se ha descargado el
 * archivo.
 *
 * @author ubidragon
 */
public class LibroElectronico extends Libro implements Downloadable {

    private final int size;
    private int numDescargas;
    /**
     * Mínimo tamaño de archivo permitido.
     */
    private static final int MIN_SIZE = 20;
    /**
     * Máximo tamaño de archivo permitido.
     */
    private static final int MAX_SIZE = 65535;

    /**
     * Crea un objeto LibroElectronico con un nombre, precio, texto de descripción, autor, año de edición y tamaño en Kbytes.
     * @param nombre Título del libro
     * @param precio Precio del libro
     * @param descripcion Descripción del libro
     * @param autor Autor del libro
     * @param year Año de edición del libro
     * @param size Tamaño del archivo del libro electrónico
     * @throws IllegalArgumentException si alguno de los parámetros no es válido
     */
    public LibroElectronico(String nombre, double precio, String descripcion, String autor, int year, int size) throws IllegalArgumentException {
        super(nombre, precio, descripcion, autor, year);
        checkSize(size);
        this.size = size;
    }

    /**
     * Devuelve el tamaño en Kb del archivo EBook
     * @return Tamaño en Kb del EBook
     */
    public int getSize() {
        return size;
    }

    /**
     * Devuelve el número de descargas del archivo EBook hasta el momento
     * @return número de descargas del archivo EBook hasta el momento
     */
    public int getNumDescargas() {
        return numDescargas;
    }

    private void checkSize(int size) {
        if (size > MAX_SIZE || size < MIN_SIZE) {
            throw new IllegalArgumentException("Error: Parámetros de creación del libro electrónico inválidos. El tamaño (" + size + "Kb) no está en el rango permitido");
        }
    }

    @Override
    public String[] toArrayAtribNames() {
        String[] res = new String[]{super.toArrayAtribNames()[0], super.toArrayAtribNames()[1],
            super.toArrayAtribNames()[2], super.toArrayAtribNames()[3], super.toArrayAtribNames()[4],
            "tamaño", "numero de descargas"};

        return res;
    }

    @Override
    public String[] toArrayAtribValues() {

        String[] res = new String[]{super.toArrayAtribValues()[0], super.toArrayAtribValues()[1],
            super.toArrayAtribValues()[2], super.toArrayAtribValues()[3], super.toArrayAtribValues()[4],
            Integer.toString(size), Integer.toString(getNumDescargas())};

        return res;
    }

    @Override
    public double descargar(double anchoBanda) throws IllegalArgumentException {
        double tiempo = 0.0;
        if (anchoBanda <= 0.0) {
            throw new IllegalArgumentException("Error: Parámetro de descarga inválido. Ancho de banda incompatible (" + anchoBanda + ")");
        } else {
            numDescargas = getNumDescargas() + 1;
            tiempo = getSize() / anchoBanda;
        }
        return tiempo;
    }

}
