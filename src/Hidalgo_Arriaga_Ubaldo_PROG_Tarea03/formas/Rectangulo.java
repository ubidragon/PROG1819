package Hidalgo_Arriaga_Ubaldo_PROG_Tarea03.formas;

import Hidalgo_Arriaga_Ubaldo_PROG_Tarea03.utilidades.ES;

/**
 * Clase que representa un rect�ngulo, que tendr� un n�mero de columnas, filas,
 * se representar� por un car�cter determinado, que repetido en filas y columnas
 * formar� el rect�ngulo. Y que estar� realizado con un color determiando, 
 * representado en un enumerado.
 * 
 * @author Jos� Javier Berm�dez Hern�ndez
 */
public class Rectangulo {
    
    public static final int MAX_FILAS = 40 ;
    public static final int MAX_COLUMNAS = 80 ;
    
    /** Car�cter usado para dibujar el rect�ngulo por consola */
    private char caracter ;     
    /** Columnas que tendr� el dibujo */
    private int columnas ;      
    /** Filas que tendr� el dibujo */
    private int filas ;         
    /** ColorTexto del rect�ngulo */
    private Color color ; 

    
    /** Enumerado con los valores que se permiten como atributo del color. */
    public enum Color {
        /** ColorTexto rojo */
        ROJO,
        /** ColorTexto negro */
        VERDE, 
        /** ColorTexto blanco */
        AZUL , 
        /** ColorTexto amarillo */
        AMARILLO} ;

    /**
     * Constructor por defecto de la clase. Inicializa un objeto con los
     * valores * para car�cter, 6 para las columnas, 3 para las filas y NEGRO
     * como color.
     */
    public Rectangulo() {
        this.caracter = '*' ;
        this.columnas = 6 ;
        this.filas = 3 ;
        this.color = Color.ROJO ;
    }
    
    /**
     * Constructor con par�metros.
     * @param caracter  Car�cter con el que se dibujar� por consola el rect�ngulo.
     * @param filas     Filas de el rect�ngulo.
     * @param columnas  Columnas de el rect�ngulo.
     * @param color  ColorTexto con el que se hace el rect�ngulo. 
     * @throws IllegalArgumentException Se lanza la excepci�n si las filas y/o 
     *  las columnas recibidas como par�metro son iguales a 0 o negativas.
     */
    public Rectangulo(char caracter, int filas, int columnas, Color color) throws IllegalArgumentException {
        if (columnas > 0 && filas > 0) {
            this.caracter = caracter;
            this.columnas = columnas;
            this.filas = filas;
            this.color = color ;
        }
        else  {
            throw new IllegalArgumentException("Medida(s) no permitidas") ;
        }
    }
    
    /**
     * Devuelve el car�cter de el rect�ngulo.
     * @return Car�cter de al caja.
     */
    public char getCaracter() {
        return caracter;
    }

    /**
     * Establece el car�cter del rect�ngulo.
     * @param caracter Car�cter del rect�ngulo.
     */
    public void setCaracter(char caracter) {
        this.caracter = caracter;
    }

    /**
     * Devuelve las columnas del rect�ngulo.
     * @return Columnas del rect�ngulo.
     */
    public int getColumnas() {
        return columnas;
    }

    /**
     * Establece las columnas del rect�ngulo.
     * @param columnas Columnas del rect�ngulo.
     */
    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }

    /**
     * Devuelve las filas del rect�ngulo.
     * @return filas del rect�ngulo.
     */
    public int getFilas() {
        return filas;
    }

    /**
     * Establece las filas del rect�ngulo.
     * @param filas Filas del rect�ngulo
     */
    public void setFilas(int filas) {
        this.filas = filas;
    }
 
    /**
     * ColorTexto de el rect�ngulo.
     * @return Devuelve el color del rect�ngulo.
     */
    public Color getColor() {
        return this.color ;
    }

    
    /**
     * Asigna un color al objeto.
     * @param color ColorTexto que se asignar� al objeto.
     */
    public void setColor(Color color) {
        this.color = color ;
    }

    /**
     * Construye y devuelve la cadena de caracteres con la informaci�n del
     * rect�ngulo.
     * @return cadena de caracteres con la informaci�n del rect�ngulo.
     */
    @Override
    public String toString() {
        return "El rect�ngulo se dibuja con el car�cter: " + this.caracter + 
                " y se dibujar� con: " + this.columnas + " columnas y " +
                this.filas + " filas. El color del rect�ngulo es: " + 
                this.color ;
    }
    
    
    
    /**
     * Construye la cadena de caracteres que representa el rect�ngulo dibujado.
     * @param relleno Si se quiere dibujar el rect�ngulo relleno o s�lo el borde.
     * @return La cadena de caracteres que representa el rect�ngulo.
     */
    public String dibujar2D(boolean relleno) {
        StringBuilder resultado = new StringBuilder();
        String secEscColor="";
        switch (this.color)
        {
            case ROJO: secEscColor=ES.ColorTexto.ROJO.codigoColorTexto(); break;
            case VERDE: secEscColor=ES.ColorTexto.VERDE.codigoColorTexto(); break;
            case AZUL: secEscColor=ES.ColorTexto.AZUL.codigoColorTexto(); break;
            case AMARILLO: secEscColor=ES.ColorTexto.AMARILLO.codigoColorTexto(); break;
        }
        for (int y=0; y<this.filas; y++) {
            resultado.append(secEscColor);
            for (int x=0; x<this.columnas; x++) {
                
                if (x==0 || y==0 || y==this.filas-1 ||x==this.columnas-1 ) {
                    resultado.append(caracter) ;
                } else {
                    if (relleno) {
                        resultado.append(caracter) ;
                    } else {
                        resultado.append(" ") ;
                    }
                    
                }
   
            }
            resultado.append("\n");
        }
        resultado.append(ES.ColorTexto.RESET.codigoColorTexto());
        // Devolvemos la cadena construida*/
        return resultado.toString();
    }
        
    
    /**
     * Convertir n�mero a tipo de color 
     * @param   elColor N�mero entero que representa el tipo de color.
     * @return  Devolver� el valor del enumerado seg�nn el entero recibido como
 par�metro. As�, para 1 se devolver� ROJO, para 2 se devolver� NEGRO, 
 para 3 se devolver� BLANCO y para 4 AMARILLO.
 En caso de recibir cualquier otro valor, devolver� ColorTexto.ROJO
     */
    public static Color enteroAcolor(int elColor) {
        Color tipo = Color.ROJO ;
                
        switch(elColor) {
            case 1: 
                tipo = Color.ROJO ;
                break ;
            case 2:
                tipo = Color.VERDE ;
                break ;
            case 3:
                tipo = Color.AZUL ;
                break ;
            case 4:
                tipo = Color.AMARILLO ;
                break ;
        }
        return tipo ;
    }
    
            
    /**
     * Aumentar o disminuir las filas (altura) de un rec�ngulo en las unidades
     * que se pasen como par�metro.
     * Se comprueba en el caso de que el valor de las unidades pasadas como 
     * par�metro sean positivas, si al sumarlas a las dimensiones actuales nos
     * pasamos del tama�o m�ximo, y en ese caso no se incrementar� el valor.
     * Del mismo modo, si se psa un valor negativo, se comprueba antes de 
     * asignar si el resultado de la opraci�n ocasionar�a un valor de filas de
     * 0 o menos, lo cual no estar�a permitido tampoco.
     * 
     * @param unidades Unidades a agrandar o disminuir.
     * @return true si se agrand� o disminuy�, y false si no se hizo.
     */
    public boolean modificarAltura(int unidades){
        boolean resultado = false ;
        if ((unidades > 0 || (this.filas + unidades >= 0)) && (this.filas + unidades <= MAX_FILAS) && (this.filas + unidades >= 1))  {
            this.filas += unidades ;
            resultado = true ;
        }
        return resultado ;
    }
    
    
    /**
     * Aumentar o disminuir anchura en las unidades que se pasen como par�metro, 
     * si el par�metro que se pasa es un entero mayor de 0.
     * @param unidades Unidades a agrandar o disminuir.
     * @return true si se modific� o false si no se hizo.
     */
    public boolean modificarAnchura(int unidades) {
        boolean resultado = false ;
        if ((unidades > 0 || (this.columnas + unidades >= 0)) && (this.columnas + unidades <= MAX_COLUMNAS)&& (this.columnas + unidades >= 1))  {
            this.columnas += unidades ;
            resultado = true ;
        }
        return resultado ;
        
    }
    
    /**
     * Girar el rect�ngulo. Consiste en intercambiar el valor de las filas por
     * las columnas.
     */
    public void girarRectangulo() {    
        int temp = this.columnas ;
        this.columnas = this.filas ;
        this.filas = temp ;
    }
        
}