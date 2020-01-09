/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hidalgo_Arriaga_Ubaldo_PROG_Tarea06.libreria;

/**
 *
 * Interfaz que incorpora la capacidad de obtener el contenido del objeto en forma de arrays.
 * 
 * @author ubidragon
 */
public interface Arrayable {
    
    /**
     * Genera array de nombres de atributos.
     * @return array de String con los nombres de los atributos de la clase de la cual el objeto es instancia
     */
    String[] toArrayAtribNames();
    /**
     * Genera array de valores de atributos.
     * @return array de String con los valores de los atributos del objeto
     */
    String[] toArrayAtribValues();
    
}
