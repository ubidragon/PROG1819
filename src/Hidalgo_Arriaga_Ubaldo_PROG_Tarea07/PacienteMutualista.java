/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hidalgo_Arriaga_Ubaldo_PROG_Tarea07;

/**
 *
 * @author ubidragon
 */
public class PacienteMutualista extends Paciente {

    public int numeroDeHospitalizaciones;
    public static int numeroPacientesMutualistas;

    public PacienteMutualista(String nif, String nombrePaciente, String emailNotificaciones, Tipos_Paciente tipo) {
        super(nif, nombrePaciente, emailNotificaciones, tipo);
        
    }

    public PacienteMutualista(Paciente paciente) {
        super(paciente);
    }

    public int getNumeroDeHospitalizaciones() {
        return numeroDeHospitalizaciones;
    }

    public void setNumeroDeHospitalizaciones(int numeroDeHospitalizaciones) throws IllegalArgumentException{
        if (numeroDeHospitalizaciones >=0 && numeroDeHospitalizaciones<=100) {
            this.numeroDeHospitalizaciones = numeroDeHospitalizaciones;
        }else{
            throw new IllegalArgumentException("Introduzca un numero de 0 a 100.");
        }
        
    }
        
    @Override
    public String toString() {
        StringBuilder paciente = new StringBuilder();
        paciente.append("Paciente Mutualista-->");
        paciente.append(super.toString());
         paciente.append("\nNumero de Hospitalizaciones: ").append(getNumeroDeHospitalizaciones());
        return paciente.toString();
    }

}
