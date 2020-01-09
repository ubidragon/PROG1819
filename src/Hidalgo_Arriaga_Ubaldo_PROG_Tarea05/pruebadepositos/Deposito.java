/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hidalgo_Arriaga_Ubaldo_PROG_Tarea05.pruebadepositos;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

/**
 *
 * Clase que representa un <strong>depósito</strong> de estructura
 * <strong>cilíndrica</strong>.
 * <p>
 * Los objetos de esta clase contienen atributos que permiten almacenar
 * información sobre:</p>
 * <ul>
 * <li><strong>Altura</strong> del depósito.</li>
 * <li><strong>Radio de la base</strong> del depósito.</li>
 * <li><strong>Caudal de salida</strong> del grifo del depósito.</li>
 * <li><strong>Nivel actual</strong> del depósito.</li>
 * <li><strong>Volumen total</strong> que ha <strong>almacenado</strong>
 * el depósito desde que se creó.</li>
 * <li><strong>Volumen total</strong> que ha <strong>vertido</strong>
 * el depósito desde que se creó.</li>
 * </ul>
 * <p>
 * La clase también dispone de información general independiente de los objetos
 * concretos que se hayan creado. Es el caso de:</p>
 * <ul>
 * <li><strong>Volumen total</strong> que han <strong>almacenado</strong> todos
 * los depósitos hasta el momento.</li>
 * <li><strong>Volumen total</strong> que han <strong>vertido</strong> todos los
 * depósitos hasta el momento.</li>
 * <li><strong>Número de depósitos totalmente vacíos</strong> en el momento
 * actual.</li>
 * <li><strong>Número de depósitos totalmente llenos</strong> en el momento
 * actual.</li>
 * <li><strong>Número total de depósitos</strong> existentes en el momento
 * actual.</li>
 * </ul>
 *
 * @author Ubaldo Hidalgo Arriaga
 */
public class Deposito {

    //Constantes
    /**
     * Valor por omisión (o por defecto) para la altura de un depósito, 1.0
     * metros
     */
    static double DEFAULT_ALTURA = 1.0;
    /**
     * Valor por omisión (o por defecto) para el caudal de salida del grifo de
     * un depósito, 0.10 litros/segundo
     */
    static double DEFAULT_CAUDAL_SALIDA = 0.10;

    /**
     * Valor por omisión (o por defecto) para el radio de la base de un
     * depósito, 0.5 metros
     */
    static double DEFAULT_RADIO = 0.5;

    /**
     * Altura máxima de un depósito, 20.0 metros
     */
    static double MAX_ALTURA = 20.0;

    /**
     * Caudal de salida máximo del grifo de un depósito, 1.0 litros/segundo
     */
    static double MAX_CAUDAL = 1.0;

    /**
     * Longitud máxima del radio de la base de un depósito, 10.0 metros
     */
    static double MAX_RADIO = 10.0;

    /**
     * Relación máxima entre radio y altura, 0.5.
     */
    static double MAX_RATIO_ALTURA_RADIO = 0.5;

    /**
     * Altura mínima de un depósito, 0.20 metros
     */
    static double MIN_ALTURA = 0.20;

    /**
     * Caudal de salida mínimo del grifo de un depósito, 0.001 litros/segundo
     */
    static double MIN_CAUDAL = 0.001;

    /**
     * Longitud mínima del radio de la base de un depósito, 0.20 metros
     */
    static double MIN_RADIO = 0.20;

    final double ALTURA;
    final double RADIO;
    final double CAUDALSALIDA;
    static double volumenGlobalActual = 0.0;
    static double volumenGlobalIntroducido = 0.0;
    static double volumenGlobalVertido = 0.0;
    static long numDepositosLlenos = 0L;
    static long numDepositosVacios = 0L;
    double nivelActual = 0.0;
    double volumenIntroducidoDesdeCreacion = 0.0;
    double volumenVertidoDesdeCreacion = 0.0;

    /**
     *
     * Constructor por defecto de la clase.<br> Crea un objeto Deposito con un
     * consumo altura de 1 metro, un radio de 0.5 metros y un caudal de salida
     * de 0.10 litros/seg.
     *
     */
    public Deposito() {
        this(DEFAULT_ALTURA, DEFAULT_RADIO, DEFAULT_CAUDAL_SALIDA);
    }

    /**
     * Constructor con dos parámetros.
     *
     * @param altura altura del depósito (metros).
     * @param radio radio de la base del depósito (metros). La altura no puede
     * ser menor de la mitad del radio.
     * @throws IllegalArgumentException si alguno de los parámetros está fuera
     * del rango permitido o no cumple los requisitos de geometría (el radio no
     * puede ser superior al doble de la altura).
     */
    public Deposito(double altura, double radio) throws java.lang.IllegalArgumentException {
        this(altura, radio, DEFAULT_CAUDAL_SALIDA);

    }

    /**
     * Constructor con tres parámetros
     *
     * @param altura altura del depósito (metros).
     * @param radio radio de la base del depósito (metros). La altura no puede
     * ser menor de la mitad del radio.
     * @param caudalSalida caudal de salida del grifo de vertido del depósito
     * (litros/segundo).
     * @throws IllegalArgumentException si alguno de los parámetros está fuera
     * del rango permitido o no cumple los requisitos de geometría (el radio no
     * puede ser superior al doble de la altura).
     */
    public Deposito(double altura, double radio, double caudalSalida) throws java.lang.IllegalArgumentException {
        checkParametros(altura, radio, caudalSalida);
        this.ALTURA = altura;
        this.RADIO = radio;
        this.CAUDALSALIDA = caudalSalida;
        numDepositosVacios++;
    }

    /**
     *
     * Obtiene la capacidad del depósito(en litros)
     *
     * @return capacidad del depósito (en litros)
     */
    public double getCapacidad() {
        double capacidad;
        double convert = Math.pow(10, 3);
        capacidad = (Math.PI * Math.pow(RADIO, 2) * this.ALTURA) * convert;
        return capacidad;
    }

    /**
     * Obtiene el caudal de salida del grifo del depósito(en litros/segundo).
     *
     * @return caudal de salida del grifo del depósito (en litros/segundo)
     */
    public double getCaudalSalida() {
        return CAUDALSALIDA;
    }

    /**
     * Indica si el depósito está completamente vacío.
     *
     * @return true si el depósito está completamente vacío
     */
    public boolean estaVacio() {
        boolean estado = true;
        if (getNivelActual() != 0.0) {
            estado = false;

        }
        return estado;
    }

    /**
     *
     * Indica si el depósito está completamente lleno.
     *
     * @return true si el depósito está completamente lleno
     */
    public boolean estaLleno() {
        boolean estado = false;
        if (getNivelActual() == getCapacidad()) {
            estado = true;

        }
        return estado;
    }

    /**
     *
     *
     *
     * @return nivel actual del depósito (en litros)
     */
    public double getNivelActual() {
        return this.nivelActual;
    }

    /**
     * Obtiene la cantidad de litros totales almacenados por el depósito desde
     * su fabricación.
     *
     * @return cantidad de litros totales almacenados por el depósito desde su
     * fabricación
     */
    public double getVolumenIntroducidoDesdeCreacion() {
        return volumenIntroducidoDesdeCreacion;
    }

    /**
     * Obtiene la cantidad de litros totales vertidos por el depósito desde su
     * fabricación.
     *
     * @return cantidad de litros totales vertidos por el depósito desde su
     * fabricación
     */
    public double getVolumenVertidoDesdeCreacion() {
        return volumenVertidoDesdeCreacion;
    }

    /**
     *
     * Obtiene la cantidad de litros totales almacenados por todos los depósitos
     * en el momento actual.
     *
     * @return cantidad de litros totales almacenados por todos los depósitos en
     * el momento actual
     */
    public static double getVolumenGlobalActual() {
        return volumenGlobalActual;
    }

    /**
     * Obtiene la cantidad de litros totales almacenados por todos los depósitos
     * durante toda la historia de los depósitos hasta el momento actual
     *
     * @return cantidad de litros totales almacenados por todos los depósitos
     * durante toda la historia de los depósitos hasta el momento actual
     */
    public static double getVolumenGlobalIntroducido() {
        return volumenGlobalIntroducido;
    }

    /**
     * Obtiene la cantidad de litros totales vertidos por todos los depósitos
     * durante toda la historia de los depósitos hasta el momento actual
     *
     * @return cantidad de litros totales vertidos por todos los depósitos
     * durante toda la historia de los depósitos hasta el momento actual
     */
    public static double getVolumenGlobalVertido() {
        return volumenGlobalVertido;
    }

    /**
     * Obtiene el número de depósitos completamente llenos en el momento actual.
     *
     * @return número de depósitos completamente llenos en el momento actual
     */
    public static long getNumDepositosLlenos() {

        return numDepositosLlenos;
    }

    /**
     * Obtiene el número de depósitos completamente vacíos en el momento actual.
     *
     * @return número de depósitos completamente vacíos en el momento actual.
     */
    public static long getNumDepositosVacios() {

        return numDepositosVacios;
    }

    /**
     * Rellena el depósito una determinada cantidad de litros.
     *
     * @param litros - Cantidad de litros con los que se desea rellenar el
     * depósito
     * @throws java.lang.IllegalArgumentException - si se produce un
     * rebosamiento debido a que la cantidad de litros de llenado es superior a
     * la que cabe en ese momento en el depósito
     *
     *
     *
     */
    public void llenar(double litros) throws java.lang.IllegalArgumentException {

        if (estaLleno()) {
            throw new IllegalArgumentException("Deposito lleno, no se ha podido llenar.");
        } else if (litros == 0.0) {
            throw new IllegalArgumentException("Ha introducido 0 Litros.");
        } else if ((nivelActual + litros) > getCapacidad()) {
            if (estaVacio()) {
                numDepositosVacios--;
            }
            double litrosRestantes = getCapacidad() - getNivelActual();
            double litrosSobrantes = litros - litrosRestantes;

            volumenGlobalActual += litrosRestantes;
            volumenGlobalIntroducido += litrosRestantes;
            volumenIntroducidoDesdeCreacion += litrosRestantes;

            nivelActual += litrosRestantes;
            if (estaLleno()) {
                numDepositosLlenos++;
            }

            throw new IllegalArgumentException(String.format("Error: Depósito lleno. "
                    + "Se ha desbordado en %5.2f litros.", litrosSobrantes));
        } else {

            if (estaVacio()) {
                numDepositosVacios--;
            }

            volumenGlobalActual += litros;
            volumenGlobalIntroducido += litros;
            volumenIntroducidoDesdeCreacion += litros;
            nivelActual += litros;
            if (estaLleno()) {
                numDepositosLlenos++;
            }

        }

    }

    /**
     * Abre el grifo del depósito una determinada cantidad de segundos.
     *
     * @param segundos - Cantidad de segundos durante los que se desea abrir el
     * grifo del depósito
     * @return cantidad de litros vertidos mientras el grifo ha estado abierto
     * @throws java.lang.IllegalArgumentException - si la cantidad de segundos
     * es inválida (número negativo)
     *
     *
     */
    public double abrirGrifo(double segundos)
            throws java.lang.IllegalArgumentException {
        double vertido = 0.0;

        if (Double.isNaN(segundos)) {
            throw new IllegalArgumentException("Error: Parámetro de tiempo "
                    + "inválido (null).");
        } else if (segundos <= 0) {
            throw new IllegalArgumentException("Error: Parámetro de tiempo "
                    + "inválido (tiempo negativo).");
        } else if (estaVacio()) {
            throw new IllegalArgumentException("No se puede abrir el grifo, "
                    + "el deposito esta vacio.");

        } else if ((getCaudalSalida() * segundos) > getNivelActual()) {
            if (estaLleno()) {
                numDepositosLlenos--;
            }
            vertido = getNivelActual();
            volumenGlobalActual -= getNivelActual();
            volumenGlobalVertido += getNivelActual();
            volumenVertidoDesdeCreacion += getNivelActual();
            nivelActual = 0;
            numDepositosVacios++;

        } else {
            if (estaLleno()) {
                numDepositosLlenos--;
            }

            vertido = getCaudalSalida() * segundos;

            volumenGlobalActual -= vertido;
            volumenGlobalVertido += vertido;
            volumenVertidoDesdeCreacion += vertido;
            nivelActual -= vertido;
            if (estaVacio()) {
                numDepositosVacios++;
            }

        }

        return vertido;

    }

    /**
     * Abre el grifo del depósito el tiempo transcurrido entre dos instantes.
     *
     * @param inicio - instante de apertura del grifo
     * @param fin - instante de cierre del grifo
     * @return cantidad de litros vertidos mientras el grifo ha estado abierto
     * @throws java.lang.IllegalArgumentException - si el instante de inicio es
     * posterior al de fin, o si alguno de los instantes es null
     *
     *
     */
    public double abrirGrifo(LocalTime inicio, LocalTime fin) throws java.lang.IllegalArgumentException {

        double vertido;
        if (inicio == null || fin == null) {
            throw new IllegalArgumentException("Error: Parámetro de tiempo "
                    + "inválido (null).");
        } else if (ChronoUnit.SECONDS.between(inicio, fin) < 0) {

            throw new IllegalArgumentException("Error: Parámetro de tiempo "
                    + "inválido(el instante de inicio es posterior al de fin)");
        } else if (estaVacio()) {
            throw new IllegalArgumentException("No se puede abrir el grifo, "
                    + "el deposito esta vacio.");

        } else {
            vertido = abrirGrifo(Double.valueOf((ChronoUnit.SECONDS.between(inicio, fin))));

        }

        return vertido;

    }

    /**
     *
     * Abre el grifo del depósito hasta que quede completamente vacío.
     *
     * @return tiempo necesario para que el depósito se haya vaciado(segundos)
     */
    public double vaciar() {
        double time = getNivelActual() / getCaudalSalida();
        if (!estaVacio()) {
            if (estaLleno()) {
                numDepositosLlenos--;
            }

            volumenGlobalActual -= getNivelActual();
            volumenGlobalVertido += getNivelActual();
            volumenVertidoDesdeCreacion += getNivelActual();

            numDepositosVacios++;

            nivelActual = 0;
        }

        return time;
    }

    /**
     * Devuelve una cadena que representa el estado actual del depósito. Esa
     * cadena proporcionará la siguiente información.
     * <ul>
     * <li>Capacidad del depósito.</li>
     * <li>Nivel del depósito actual.</li>
     * <li>Volumen almacenado histórico desde que se construyó el objeto.</li>
     * <li>Volumen vertido histórico desde que se construyó el objeto.</li>
     * </ul>
     * <br>
     * El formato de salida será del siguiente tipo:
     *
     * <br>Capacidad: XXX litros - NivelActual: YYY litros - AlmacenadoTotal:
     * ZZZ litros - VertidoTotal: WWW litros
     *
     * donde XXX será la capacidad del depósito, expresada en litros con dos
     * decimales; YYY será el nivel actual del depósito expresado en litros con
     * dos decimales; ZZZ será el volumen total almacenado desde que se
     * construyó el depósito, expresado en litros con dos decimales, y WWW el
     * volumen total vertido desde que se construyó el depósito, expresado en
     * litros con dos decimales.
     *
     * Algunos ejemplos de este String de salida podrían ser:
     * <br>
     * Capacidad: 196,35 litros - NivelActual: 99,00 litros - AlmacenadoTotal:
     * 100,00 litros - VertidoTotal: 1,00 litros
     * <br>
     * Capacidad: 50,27 litros - NivelActual: 0,27 litros - AlmacenadoTotal:
     * 100,27 litros - VertidoTotal: 100,00 litros
     * <br>
     * Capacidad: 100,53 litros - NivelActual: 38,00 litros - AlmacenadoTotal:
     * 50,00 litros - VertidoTotal: 12,00 litros
     * <br>
     * Capacidad: 785,40 litros - NivelActual: 0,00 litros - AlmacenadoTotal=
     * 0.0: 0,00 litros - VertidoTotal: 0,00 litros
     * <br>
     * Capacidad: 196,35 litros - NivelActual: 0,00 litros - AlmacenadoTotal:
     * 950,00 litros - VertidoTotal: 950,00 litros
     *
     * @return Cadena que representa el estado actual del depósito.
     */
    public String toString() {
        StringBuilder msg = new StringBuilder();

        msg.append("Capacidad: ").append(String.format("%5.2f", getCapacidad())).append(" litros -");
        msg.append("Nivel Actual: ").append(String.format("%5.2f", getNivelActual())).append(" litros -");
        msg.append("Almacenado Total: ").append(String.format("%5.2f", getVolumenIntroducidoDesdeCreacion())).append(" litros -");
        msg.append("Vertido Total: ").append(String.format("%5.2f", getVolumenVertidoDesdeCreacion())).append(" litros.\n");

        return msg.toString();

    }

    private void checkParametros(double altura, double radio, double caudalSalida) {
        /*Se procedera a dar un peso a cada variable, se sigue el patron de GNU/Linux,
        altura = 4, radio = 2, caudal = 1. que se ira almacenando en una variable para determinar que parametros son erroneos.
         */
        int counter = 0;
        StringBuilder msg = new StringBuilder("Datos erroneos: ");

        if (!(altura >= MIN_ALTURA && altura <= MAX_ALTURA)) {
            counter += 4;
        }
        if (!(radio >= MIN_RADIO && radio <= MAX_RADIO && radio * MAX_RATIO_ALTURA_RADIO <= altura)) {
            counter += 2;

        }
        if (!(caudalSalida >= MIN_CAUDAL && caudalSalida <= MAX_CAUDAL)) {
            counter += 1;
        }

        switch (counter) {

            case 7:
                msg.append("Los 3 parametros proporcionados son erroneos");
                break;
            case 6:
                msg.append("Se ha introducido erroneamente la altura y el radio");
                break;
            case 5:
                msg.append("Se ha introducido erroneamente la altura y el caudal");
                break;
            case 4:
                msg.append("Se ha introducido erroneamente la altura");
                break;
            case 3:
                msg.append("Se ha introducido erroneamente el radio y el caudal");
                break;
            case 2:
                msg.append("Se ha introducido erroneamente el radio");
                break;
            case 1:
                msg.append("Se ha introducido erroneamente el caudal");
                break;

        }

        if (counter != 0) {
            throw new IllegalArgumentException(msg.toString());
        }
    }

}
