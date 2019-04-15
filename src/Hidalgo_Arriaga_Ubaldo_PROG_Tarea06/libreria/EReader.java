/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria;

/**
 *
 * Clase que representa un producto de tipo EReader para la gestión de productos
 * en una tienda. Los objetos de esta clase contienen atributos que permiten
 * almacenar toda la información relativa a un producto de tipo EReader (lector
 * de libros electrónicos) en una tienda. Además de los atributos propios de un
 * producto, deberá contener los específicos de un EReader, que son:
 *
 * Fabricante del EReader (Amazon, BQ, Sony, Onyx, ICARUS, etc.).
 *
 * @author ubidragon
 */
public class EReader extends Producto {

    protected String fabricante;

    /**
     * Crea un objeto ERreader con un nombre, precio, texto de descripción y fabricante.
     * @param nombre Nombre del dispostivo
     * @param precio Precio del dispostivo
     * @param descripcion Descripción del dispostivo
     * @param fabricante fabricante del dispostivo
     * @throws IllegalArgumentException  si alguno de los parámetros no es válido
     */
    public EReader(String nombre, double precio, String descripcion, String fabricante) throws IllegalArgumentException {
        super(descripcion, nombre, precio);
        this.fabricante = fabricante;
    }

    /**
     * Devuelve el nombre del fabricante del dispositivo
     * @return descripción del producto
     */
    public String getFabricante() {
        return fabricante;
    }

    @Override
    public String[] toArrayAtribNames() {
        String[] res = new String[]{super.toArrayAtribNames()[0], super.toArrayAtribNames()[1],
            super.toArrayAtribNames()[2], "fabricante"};

        return res;
    }
   
    @Override
    public String[] toArrayAtribValues() {

        String[] res = new String[]{super.toArrayAtribValues()[0], super.toArrayAtribValues()[1],
            super.toArrayAtribValues()[2], getFabricante()};

        return res;
    }

}
