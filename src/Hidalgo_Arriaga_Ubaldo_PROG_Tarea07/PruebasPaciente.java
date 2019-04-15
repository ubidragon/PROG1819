/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hidalgo_Arriaga_Ubaldo_PROG_Tarea07;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import utilidades.ES;

/**
 *
 * @author ubidragon
 */
public class PruebasPaciente {

    private static final int MAX_PATIENTS = 40;
    private static boolean diff = false;

    /**
     *
     * Metodo principal de la aplicacion
     *
     * @param args parametro estandart
     * @throws FileNotFoundException En caso de que no se encuentre el fichero
     * @throws IOException En caso de que haya un error de lectura y escritura
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {

        boolean key = false;
        Paciente[] patients = new Paciente[MAX_PATIENTS];
        String file = checkOS();
        patients = loadExistFile(file, patients);
       while (key != true) {
            try {
                ES.msg(menu());
                int respuesta = ES.leeEntero();
                switch (respuesta) {
                    case 0:
                        checkSaveBeforeExit(diff, patients, file);
                        ES.msgln("Cerrando aplicación... ");
                        key = true;
                        break;
                    case 1:
                        addClinicPatient(patients);
                        break;
                    case 2:
                        ES.msg(patientList(patients));
                        break;
                    case 3:
                        deletePatient(patients);
                        break;
                    case 4:
                        String save = saveInFile(patients, file)
                                ? ("Los datos se han guardado correctamente en el fichero pacientes.dat" + file)
                                : ("Los datos NO se han guardado correctamente en el fichero " + file);
                        diff = saveInFile(patients, file) ? false : diff;
                        ES.msgln(save);
                        break;
                    case 5:
                        patients = checkOverwrite(diff, patients, file);
                        break;
                    case 6:
                        String path = ES.leeCadena("¿Que nombre desea darle al archivo txt?"
                                + "\nNo es necesario incluir la extension") + ".txt";
                        exportClinic(patients,path);
                        break;
                    default:
                        //Si se equivoca de opcion vuelve al menu
                        ES.msg(menu());
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
            // Cierre del bucle
        }

    }

    private static void exportClinic(Paciente[] patients, String path) {

        if (patients[0] == null) {
            ES.msgln("La lista de pacientes está vacía.");
        } else {
            PrintWriter impresionFichero = null;
            try (FileWriter fichero = new FileWriter(path)) {
                impresionFichero = new PrintWriter(fichero);
                for (int i = 0; i < patients.length && patients[i] != null; ++i) {
                    impresionFichero.println(patients[i].toString());
                }
                fichero.close();
                ES.msgln("Fichero creado con éxito.");
            } catch (FileNotFoundException fnfe) {
                ES.msgln("El fichero " + path + " no existe.");
            } catch (IOException ioe) {
                ES.msgln("Error de Entrada/Salida: falló la lectura del fichero. "
                        + "La aplicación sigue funcionando sin haber cargado los "
                        + "datos del archivo, para permitir crearlo de nuevo.");
            }

        }
    }

    private static Paciente[] loadExistFile(String file, Paciente[] patients) {
        File myFile = new File(file);
        if (myFile.exists()) {
            patients = checkOverwrite(diff, patients, file);
            ES.msgln("Datos del fichero cargados.");
        } else {
            ES.msgln("La aplicación no tiene datos guardados.");
        }
        return patients;
    }

    private static String checkOS() {
        String file;
        String os = System.getProperty("os.name");
        if (os.startsWith("Windows")) {
            file = ".\\pacientes.dat";
        } else {
            file = "./pacientes.dat";
        }
        return file;
    }

    /*Opcion 1.a: Se encarga de crear el paciente que añadiremos. */
    /**
     * Crea el paciente segun los parametros que escoja el usuario
     *
     * @param paciente Paciente a generar
     */
    private static void createPatient(Paciente[] patients) {
        Paciente new_patient;
        for (int i = 0; i < patients.length; i++) {
            //Buscamos la primera posicion del array que este vacio para no pisar valores al añadir la caja
            if (patients[i] == null) {
                ES.msgln("Introduzca los datos del paciente:");
                String nif = ES.leeCadena("Escriba el NIF del paciente:");
                checkExistencia(patients, i, nif);

                String nombre = ES.leeCadena("Escriba el nombre del paciente:");
                String email = ES.leeCadena("Escriba el email del paciente:");
                int patient_type_number = ES.leeEntero("Escriba el tipo de paciente (1-> PRIVADO, 2-> MUTUALISTA)");
                Tipos_Paciente patient_type = Paciente.enteroATipo(patient_type_number);

                new_patient = createAccordingType(patient_type, nif, nombre, email);
                patients[i] = new_patient;
                increasePatientsAccordingTyper(new_patient);
                diff = true;
                ES.msg("Se ha añadido un nuevo paciente.");
                i = patients.length;
            }
        }
    }

    private static void increasePatientsAccordingTyper(Paciente new_patient) {
        if (new_patient.getClass().equals(PacientePrivado.class)) {

            PacientePrivado.numeroPacientesPrivados++;
        } else if (new_patient.getClass().equals(PacienteMutualista.class)) {

            PacienteMutualista.numeroPacientesMutualistas++;
        }
        Paciente.numeroPacientes++;
    }

    private static Paciente createAccordingType(Tipos_Paciente patient_type, String nif, String nombre, String email) {
       Paciente new_patient;
        if (patient_type == Tipos_Paciente.MUTUALISTAS) {
            PacienteMutualista new_patient_mutual = new PacienteMutualista(nif, nombre, email, patient_type);
            new_patient_mutual.setNumeroDeHospitalizaciones(ES.leeEntero("Escriba número de hospitalizaciones del paciente (0,100)"));
            new_patient = new_patient_mutual;
        } else {
            PacientePrivado new_patient_priv = new PacientePrivado(nif, nombre, email, patient_type);
            new_patient_priv.setNumeroDeVisitas(ES.leeEntero("Escriba número de hospitalizaciones del paciente (0,150)"));
            new_patient = new_patient_priv;
        }
        return new_patient;
    }

    private static void checkExistencia(Paciente[] patients, int i, String nif) throws IllegalArgumentException {
        if (!(patients[0] == null)) {
            for (int j = 0; j < i; j++) {
                if (patients[j].getNif().equals(nif)) {
                    throw new IllegalArgumentException("Ya existe un paciente con ese NIF en la clínica.");
                }
            }
        }
    }

    /*Opcion 1.b: Se encarga de añadir el paciente creador a la clinica, previa comprobacion de que la clinica tiene espacio suficiente*/
    /**
     * Comprueba que hay espacio en la clinica, si lo hay llama a
     * createPatient() y añade el paciente, en caso contrario lanza una
     * excepcion.
     *
     * @param patients pacientes que hay en la clinica
     */
    private static void addClinicPatient(Paciente[] patients) {
        int espacioLibre = 0;
        try{
        for (Paciente patient : patients) {
            if (patient == null) {
                espacioLibre++;
            }
        }
        }catch (NullPointerException e){
            System.err.println("Se ha producido un error al ejecutar el programa de creacion");
        }
        if (espacioLibre == 0) {
            System.err.println("ERROR: clínica completa. No es posible dar de alta más de 40 pacientes");
        } else {
            createPatient(patients);

        }
    }

    /*Opcion 2: Listar el contenido de la clinica y devolver el numero total de pacientes*/
    /**
     * Listar el contenido de la clinica
     *
     * @param patients Pacientes de la clinica
     * @return Listado de pacientes
     */
    private static String patientList(Paciente[] patients) {
        
        StringBuilder res = new StringBuilder("\nLista pacientes de la clinica");
        res.append("\n--------------------------");
        
        try{
        for (Paciente patient : patients) {
            if (patient != null) {
                res.append("\n").append(patient.toString());
            }
        }

        res.append("\nTotal de pacientes: ").append(Paciente.numeroPacientes).append("\n");

        }catch (NullPointerException e){
            res.append("\nNo existen pacientes");
        }
        
        return res.toString();
    }

    /*Opcion 3: Eliminar paciente para ello eliminaremos el paciente al que le corresponda el nif correspondiente*/
    /**
     * Elimina del conjunto de pacientes la que tenga el nif que el usuario le
     * pasa por consola
     *
     * @param patients Conjunto de pacientes de la clinica
     */
    private static void deletePatient(Paciente[] patients) throws NullPointerException {
        ES.msg("Introduzca el nif del paciente a borrar: ");

        String nif = ES.leeCadena();

        try {
            for (int i = 0; i < patients.length; i++) {

                if (patients[i].getNif().equals(nif)) {
                    ES.msg("Se procedera al borrado del paciente:\n");
                    ES.msg(patients[i].toString());
                    ES.msg("\n¿Desea continuar con el borrado? (S/N):");
                    String respuesta = ES.leeCadena();
                    confirmaEliminacion(respuesta, patients, i);
                    i = patients.length;
                } else if ((i == patients.length - 1) && !(patients[i].getNif().equals(nif))) {
                    System.err.println("No existe el paciente en la clinica");
                }
            }

        } catch (NullPointerException e) {
            System.err.println("No existe el paciente en la clinica");
        }

    }

    private static void confirmaEliminacion(String respuesta, Paciente[] patients, int i) {
        if (respuesta.equalsIgnoreCase("S")) {
            if (patients[i].getTipo() == Tipos_Paciente.PRIVADOS) {
                PacientePrivado.numeroPacientesPrivados--;
            } else if (patients[i].getTipo() == Tipos_Paciente.MUTUALISTAS) {
                PacienteMutualista.numeroPacientesMutualistas--;
            }
            diff = true;
            Paciente.numeroPacientes--;
            patients[i] = null;

            System.out.println("El paciente ha sido eliminado");
        }
    }

    /*Opcion 4: Guardar datos en fichero .dat*/
    /**
     * Metodo que guarda la informacion de las cajas en un fichero cajas.dat
     *
     * @param cajas Cajas del almacen
     * @param file Ubicacion del fichero dentro del directorio de archivos
     * @throws FileNotFoundException Si no se encuentra el fichero especificado
     * @throws IOException Si se produce un error de escritura o lectura
     */
    private static boolean saveInFile(Paciente[] patients, String file) throws FileNotFoundException, IOException {
        boolean saving = false;

        try {
            // Abrir el fichero
            FileOutputStream fichero = new FileOutputStream(new File(file));
            ObjectOutputStream exitFile;
            exitFile = new ObjectOutputStream(fichero);

            // Guardar el vector
            exitFile.writeObject(patients);

            // Guardar el total de elementos
            exitFile.writeInt(Paciente.numeroPacientes);
            exitFile.close();
            saving = true;
        } catch (FileNotFoundException fnfe) {
            ES.msgln("Error: El fichero no existe. ");
        } catch (IOException ioe) {
            ES.msgln("Falló la grabación de datos: " + ioe.getMessage());
        }
        return saving;
    }

    /**
     * Carga los datos que hay en el fichero al array que se maneja en el
     * programa.
     *
     *
     * @param ruta Ruta del fichero de destino.
     * @return Se devuelve el array de pacientes de la clinica.
     */
    private static Paciente[] loadList(String path) {
        Paciente[] patients = null;

        try {
            FileInputStream file = new FileInputStream(new File(path));
            try (ObjectInputStream inputFile = new ObjectInputStream(file)) {
                patients = (Paciente[]) inputFile.readObject();
                Paciente.numeroPacientes = inputFile.readInt();
            }
            ES.msgln("El archivo " + path + " se ha cargado con éxito....");

        } catch (ClassNotFoundException cnfe) {
            ES.msgln("No se pudo acceder a la clase adecuada para revertir "
                    + "la serialización al leer del fichero.");
        } catch (FileNotFoundException fnfe) {
            ES.msgln("El fichero " + path + " no existe.");
        } catch (IOException ioe) {
            ES.msgln("Error de Entrada/Salida: falló la lectura del fichero. "
                    + "La aplicación sigue funcionando sin haber cargado los "
                    + "datos del archivo, para permitir crearlo de nuevo.");
        }
        return patients;
    }

    private static Paciente[] checkOverwrite(boolean diff, Paciente[] patients, String file) {
        if (diff == true) {
            String cargar = ES.leeCadena("Ha realizado cambios que no ha guardado en disco. \n"
                    + "Si continúa la carga del archivo se restaurarán los datos de disco y se perderán los cambios no guardados. \n"
                    + "¿Desea continuar con la carga y restaurar los datos del archivo? (S/N)");
            // Si se elige S, se salvan los datos, y se cierra la aplicación.
            if (cargar.equalsIgnoreCase("S")) {
                ES.msgln("Restaurando datos del archivo y desechando cambios no guardados...");
                patients = PruebasPaciente.loadList(file);
                diff = false;
                ES.msgln("Archivo restaurado en memoria.");
            } else {
                ES.msgln("Carga del archivo anulada.");
            }
        } else {
            patients = PruebasPaciente.loadList(file);
        }
        return patients;
    }

    private static void checkSaveBeforeExit(boolean diff, Paciente[] patients, String file) throws IOException {
        if (diff) {
            String guardar = ES.leeCadena("Ha realizado cambios que no ha guardado en disco. ¿Desea guardarlos antes de salir?(S/N)");
            if (guardar.equalsIgnoreCase("S")) {
                ES.msgln("Salvando cambios antes de salir...");
                boolean resultado = saveInFile(patients, file);
                if (resultado) {
                    ES.msgln("Los datos se han guardado correctamente en el fichero " + file);
                } else {
                    ES.msgln("ERROR: Los datos NO se han guardado correctamente en el fichero " + file);
                }
            } else {
                ES.msgln("Anulando cambios antes de salir...");
            }
        }
    }

    private static String menu() {
        StringBuilder menu = new StringBuilder();
        menu.append("========================================");
        menu.append("\n========= Gestión de la clínica ========");
        menu.append("\n========================================");
        menu.append("\n\t1.- Añadir un paciente.");
        menu.append("\n\t2.- Listar pacientes.");
        menu.append("\n\t3.- Borrar un paciente.");
        menu.append("\n\t4.- Guardar datos en fichero.");
        menu.append("\n\t5.- Recuperar datos desde fichero.");
        menu.append("\n\n\t6.- Escribir lista de pacientes a txt.");
        menu.append("\n\n\n\t0.- Salir de la aplicación.");
        menu.append("\n========================================");
        menu.append("\nIntroduzca la opción elegida: \n");

        return menu.toString();
    }

}
