/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hidalgo_Arriaga_Ubaldo_PROG_Tarea08;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import util.ES;

/**
 *
 * @author ubidragon
 */
public class Ejercicio_02 {

    public static void main(String[] args) {
        String[] array1 = {"Negro", "Blanco", "Rojo", "Verde", "Azul",
            "Amarillo", "Cyan", "Magenta", "Plata", "Gris", "Granate", "Oliva",
            "Verde oscuro", "Morado", "Turquesa", "Azul oscuro"};

        String[] array2 = {"#000000", "#ffffff", "#FF0000", "#00ff00",
            "#0000FF", "#FFFF00", "#00FFFF", "#FF00FF", "#c0c0c0", "#808080", "#800000",
            "#808000", "#008000", "#800080", "#008080", "#000080"};

        Map<String, String> coloresCodigo = new HashMap<>();

        cargaMapa(array1, coloresCodigo, array2);

        operaciones(coloresCodigo);

    }

    /**
     * Metodo para interacturar con el usuario para realizar diversas operaciones
     * @param coloresCodigo mapa de los colores con lo que se va a trabajar.
     */
    public static void operaciones(Map<String, String> coloresCodigo) {
        StringBuilder msg = new StringBuilder();
        String operacion = new String();
        boolean parada = false ;
        while (!parada){
            
            operacion = ES.leeCadena("Introduce un comando, el nombre del color o el del código: ");
            parada = operacion.equals("exit") || operacion.equals("salir");
            for (Entry<String, String> entry : coloresCodigo.entrySet()) {
                if (operacion.equals("list") || operacion.equals("listar")) {
                    msg.append(" - ");
                    msg.append(entry.getKey()).append(" = ").append(entry.getValue());
                    msg.append("\n");
                } else if (coloresCodigo.containsValue("#" + operacion)) {

                    if (entry.getValue().equals("#" + operacion)) {
                        msg.append("El nombre del color es: ");
                        msg.append(entry.getKey());
                    }
                } else if (operacion.equalsIgnoreCase(entry.getKey())) {
                    msg.append("El código es: ").append(coloresCodigo.get(operacion));

                }
            }
            ES.msgln(msg.toString());
            msg.delete(0, msg.length());
        } 
    }

    /**
     * Metodo para cargar los array en el mapa 
     * @param array1 array con contenido de nombres de colores
     * @param coloresCodigo mapa donde se añadiran los colores
     * @param array2 array con los codigos de los colores
     */
    public static void cargaMapa(String[] array1, Map<String, String> coloresCodigo, String[] array2) {
        for (int i = 0; i < array1.length - 1; i++) {
            coloresCodigo.put(array1[i], array2[i]);
        }
    }
}
