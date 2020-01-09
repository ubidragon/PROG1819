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
public class PacientePrivado extends Paciente {

    public int numeroDeVisitas;
    public static int numeroPacientesPrivados;

    public PacientePrivado(String nif, String nombrePaciente, String emailNotificaciones, Tipos_Paciente tipo) {
        super(nif, nombrePaciente, emailNotificaciones, tipo);
    }

    public PacientePrivado(Paciente paciente) {
        super(paciente);
    }

    public int getNumeroDeVisitas() {
        return numeroDeVisitas;
    }

    public void setNumeroDeVisitas(int numeroDeVisitas) {
        if (numeroDeVisitas >= 0 && numeroDeVisitas <= 150) {
            this.numeroDeVisitas = numeroDeVisitas;
        } else {
            throw new IllegalArgumentException("Introduzca un numero de 0 a 150.");
        }
    }

    @Override
    public String toString() {
        StringBuilder paciente = new StringBuilder();
        paciente.append("Paciente Privado-->");
        paciente.append(super.toString());
        paciente.append("\nNumero de Visitas: ").append(getNumeroDeVisitas());
        return paciente.toString();
    }

}
