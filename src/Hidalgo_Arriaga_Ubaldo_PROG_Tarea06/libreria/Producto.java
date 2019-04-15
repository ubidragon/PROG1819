/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria;

/**
 *
 * Clase abastracta que representa un producto genérico para una tienda online.
 * Los objetos de esta clase contienen atributos que permiten almacenar la
 * mínima información necesaria de un producto para ser comercializado en la
 * tienda:
 *
 * Nombre del producto. Precio del producto (valor real en el rango
 * 0.01-10000.00 euros). Descripción del producto.
 *
 * @author ubidragon
 */
public abstract class Producto implements Arrayable {

    /**
     * Descripción del producto.
     */
    protected String descripcion;
    /**
     * Máximo precio permitido.
     */
    public static double MAX_PRECIO = 10000.0;
    /**
     * Mínimo precio permitido.
     */
    public static double MIN_PRECIO = 0.01;
    /**
     * Nombre del producto
     */
    protected String nombre;
    /**
     * Precio del producto.
     */
    protected double precio;

    /**
     * Crea un objeto Producto con un nombre, un precio y un texto de descripción.
     * @param descripcion Descripción del producto.
     * @param nombre Nombre del producto
     * @param precio Precio del producto
     * @throws IllegalArgumentException 
     */
    public Producto(String descripcion, String nombre, double precio) throws IllegalArgumentException {
        checkPrecio(precio);
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.precio = precio;
    }

    /**
     * Devuelve la descripción del producto
     * @return Descripción del producto
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Devuelve el nombre del producto
     * @return Nombre del producto
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Devuelve el precio actual del producto
     * @return precio del producto
     */
    public double getPrecio() {
        return precio;
    }

    private void checkPrecio(double precio) {
        if (precio < MIN_PRECIO || precio > MAX_PRECIO) {
            throw new IllegalArgumentException("Error: Parámetros de creación del producto inválidos. El precio " + precio + " no está en el rango permitido.");
        }
    }

    @Override
    public String[] toArrayAtribNames() {
        String[] res = new String[]{"nombre", "descripcion", "precio"};

        return res;
    }

    @Override
    public String[] toArrayAtribValues() {
        String price = String.valueOf(getPrecio());
        String[] res = new String[]{getNombre(), getDescripcion(), price};

        return res;
    }

}
