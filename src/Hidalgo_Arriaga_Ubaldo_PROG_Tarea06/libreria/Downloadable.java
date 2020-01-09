/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hidalgo_Arriaga_Ubaldo_PROG_Tarea06.libreria;

/**
 *
 * Interfaz que incorpora la capacidad de ser descargado de la red.

 * @author ubidragon
 */
public interface Downloadable {

    /**
     * Descarga el elemento por la red.
     * @param anchoBanda ancho de banda del sistema (en Kb/seg)
     * @return tiempo necesario para descargar el elemento (en segundos)
     * @throws IllegalArgumentException si el ancho de banda no es mayor que cero
     */
    double descargar(double anchoBanda) throws IllegalArgumentException;
    
}
