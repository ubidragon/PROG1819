/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hidalgo_Arriaga_Ubaldo_PROG_Tarea08;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import util.ES;

/**
 *
 * @author ubidragon
 */
public class Ejercicio_03 {

    public static void main(String[] args) {
        List<Persona> personas = new ArrayList<>();
        operaciones(personas);
    }

    private static void operaciones(List<Persona> personas) {
        StringBuilder msg = new StringBuilder();
        String operacion = new String();
        boolean parada = false;
        while (!parada) {

            operacion = ES.leeCadena("¿Qué desea hacer ahora?");
            parada = operacion.equals("exit") || operacion.equals("salir");

            if (operacion.equals("list") || operacion.equals("listar")) {
                listar(msg, personas);
            } else if (operacion.equals("add") || operacion.equals("insertar")) {
                insertar(personas);
            } else if (operacion.equals("eliminar") || operacion.equals("delete")) {
                eliminar(personas, msg);
                
            } else {
                msg.append("Operaciones válidas son:").append("\n");
                msg.append("--> list o listar").append("\n");
                msg.append("--> insertar o add").append("\n");
                msg.append("--> borrar o delete").append("\n");
                msg.append("--> salir o exit");

            }

            ES.msgln(msg.toString());
            msg.delete(0, msg.length());
        }
    }

    /**
     * Metodo para elimianr personas
     * @param personas listado de donde se eliminara(n) la(s) persona(s) en cuestion
     * @param msg mensajes de informacion para el usuario
     */
    public static void eliminar(List<Persona> personas, StringBuilder msg) {
        String nombre = ES.leeCadena("Introduce el nombre:");
        String confirmacion = ES.leeCadena("¿Desea continuar con la operación (s/n)?");
        if (confirmacion.equalsIgnoreCase("s")) {
            List<Persona> nombreEliminar = new ArrayList<>();
            for (Persona persona : personas) {
                if (nombre.equalsIgnoreCase(persona.getNombre())) {
                    nombreEliminar.add(persona);
                }
            }
            personas.removeAll(nombreEliminar);
            msg.append("Eliminados ").append(nombreEliminar.size()).append(" registros.");
        }
    }

    /**
     * Metodo para insertar personas y ordenar segun edad
     * @param personas listado de personas donde se insertara la persona
     * @throws IllegalArgumentException 
     */
    public static void insertar(List<Persona> personas) throws IllegalArgumentException {
        String nombre = ES.leeCadena("Introduce el nombre de la persona: ");
        int edad = ES.leeEntero("Introduce su edad (entre 1 y 99):", 1, 99);
        String confirmacion = ES.leeCadena("¿Desea continuar con la operación (s/n)?");
        if (confirmacion.equalsIgnoreCase("s")) {
            personas.add(new Persona(nombre, edad));
            Comparator<Persona> cmp = Comparator.comparing(Persona::getEdad);
            personas.sort(cmp);
            ES.msgln("Registro añadido.");
        } else {
            ES.msgln("Operación cancelada");
        }
    }

    /**
     * Metodo para listar las personas de la lista
     * @param msg texto donde se añadira la informacion de la persona
     * @param personas listado de personas que se dispone
     */
    public static void listar(StringBuilder msg, List<Persona> personas) {
        for (Persona person : personas) {
            msg.append(person.getNombre()).append(" (").append(person.getEdad()).append(")");
            msg.append("\n");
        }
    }

}
