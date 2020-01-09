/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hidalgo_Arriaga_Ubaldo_PROG_Tarea08;

/**
 *
 * @author ubidragon
 */
public class Persona {
    private String nombre;
    private int edad;
    
    public Persona(String nombre, int edad)
    {
        this.edad=edad;
        this.nombre=nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }
}
