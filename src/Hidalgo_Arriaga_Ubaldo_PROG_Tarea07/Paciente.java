/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hidalgo_Arriaga_Ubaldo_PROG_Tarea07;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author ubidragon
 */
public abstract class Paciente implements Serializable {

    private static final long serialVersionUID = 14921992L;
    public String nif;
    public String nombrePaciente;
    public String emailNotificaciones;
    public static int numeroPacientes;
    public Tipos_Paciente tipo;
    
    public Paciente(String nif, String nombrePaciente, String emailNotificaciones, Tipos_Paciente tipo) throws IllegalArgumentException{
        isNifNumValid(nif);
        checkEmail(emailNotificaciones);
        this.nif = nif;
        this.nombrePaciente = nombrePaciente;
        this.emailNotificaciones = emailNotificaciones;
        this.tipo=tipo;
    }

    public Paciente(Paciente paciente) {
        this(paciente.nif, paciente.nombrePaciente, paciente.emailNotificaciones, paciente.tipo);
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public String getEmailNotificaciones() {
        return emailNotificaciones;
    }

    public void setEmailNotificaciones(String emailNotificaciones) {
        this.emailNotificaciones = emailNotificaciones;
    }

    public Tipos_Paciente getTipo() {
        return tipo;
    }

    public int getNumeroPacientes() {
        return numeroPacientes;
    }

    public void setNumeroPacientes(int numeroPacientes) {
        this.numeroPacientes = numeroPacientes;
    }
    
    
    

    private void checkEmail(String email) {
        Matcher m = Pattern.compile("^[a-zA-Z0-9._-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$").matcher(email);
        if (m.matches() == false) {
            throw new IllegalArgumentException("se ha producido un error al insertar el email, intentelo de nuevo");
        }
    }

    private void isNifNumValid(String nif) {
        //Si el largo del NIF es diferente a 9, acaba el método.
        if (nif.length() != 9) {
            throw new IllegalArgumentException("se ha producido un error al insertar el nif/nie, intentelo de nuevo");
        }

        String secuenciaLetrasNIF = "TRWAGMYFPDXBNJZSQVHLCKE";
        nif = nif.toUpperCase();

        //Posición inicial: 0 (primero en la cadena de texto).
        //Longitud: cadena de texto menos última posición. Así obtenemos solo el número.
        String numeroNIF = nif.substring(0, nif.length() - 1);

        //Si es un NIE reemplazamos letra inicial por su valor numérico.
        numeroNIF = numeroNIF.replace("X", "0").replace("Y", "1").replace("Z", "2");

        //Obtenemos la letra con un char que nos servirá también para el índice de las secuenciaLetrasNIF
        char letraNIF = nif.charAt(8);
        int i = Integer.parseInt(numeroNIF) % 23;
        if (!(letraNIF == secuenciaLetrasNIF.charAt(i))) {
            throw new IllegalArgumentException("se ha producido un error al insertar el nif/nie, intentelo de nuevo");
        }
    }

    /**
     * Metodo estatico que transformara el numero recibido por consola en uno de
     * los tipos de Paciente
     *
     * @param numero numero entero
     * @return devolvera un tipo de paciente que estara asociado a dicho numero
     *
     */
    public static Tipos_Paciente enteroATipo(int numero) {
        Tipos_Paciente patient_type;
        switch (numero) {
            case 1:
                patient_type = Tipos_Paciente.PRIVADOS;
                break;
            case 2:
                patient_type = Tipos_Paciente.MUTUALISTAS;
                break;           
            default:
                patient_type = Tipos_Paciente.MUTUALISTAS;
        }

        return patient_type;
    }
    
    @Override
    public String toString() {
        StringBuilder paciente = new StringBuilder();

        paciente.append("\n\t\tNIF/NIE: <").append(getNif()).append(">");
        paciente.append("\n\t\tNombre: <").append(getNombrePaciente()).append(">");
        paciente.append("\n\t\tEmail: <").append(getEmailNotificaciones()).append(">");

        return paciente.toString();
    }

}
