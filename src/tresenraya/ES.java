package tresenraya;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ES {
    /*public final static String nombre_archivo = System.getProperty("user.dir") + File.separator + "src" + File.separator
            + "ut7" + File.separator + "Datos.txt";
*/
	public static int leerEntero() {return 1;}
	
    
    /**
     * Leer entero.
     *
     * @param mensaje el mensaje
     * @return Devuelve un entero
     */
    public static int leerEntero(String mensaje) {
        Scanner sc = new Scanner(System.in);
        do {
            try {
                escribir(mensaje);
                return sc.nextInt();
            } catch (Exception InputMismatchException) {
                System.out.println("¡¡¡Error!!! Debes de introducir un número entero");
                sc.nextLine();
            }
        } while (true);
    }
    
    public static int leerEntero(int minimo, int maximo, String mensaje) {
        int numero = -1;
        do {
            try {
                do {
                    numero = leerEntero(mensaje);
                    if (numero < minimo || numero > maximo) {
                        escribirLn("Error. El número introducido tiene que estar entre " + minimo + " y " + maximo + " (ambos incluidos).");
                    }
                } while (numero < minimo || numero > maximo);
                return numero;
            } catch (Exception InputMismatchException) {
                System.out.println("¡¡¡Error!!! Debes de introducir un número entero");
            }
        } while (true);
    }

    public static long leerEnteroLargo() {return (long) 1;}
	
    /**
     * Leer entero largo.
     *
     * @param mensaje el mensaje
     * @return Devuleve un entero largo
     */
    public static long leerEnteroLargo(String mensaje) {
        Scanner sc = new Scanner(System.in);
        do {
            try {
                escribir(mensaje);
                return sc.nextLong();
            } catch (Exception InputMismatchException) {
                System.out.println("¡¡¡Error!!! Debes de introducir un número entero largo");
                sc.nextLine();
            }
        } while (true);
    }

    public static float leerReal() {return 1f;}
	
    /**
     * Leer real.
     *
     * @param mensaje el mensaje
     * @return Devuelve un real
     */
    public static float leerReal(String mensaje) {
        Scanner sc = new Scanner(System.in);
        do {
            try {
                escribir(mensaje);
                return sc.nextFloat();
            } catch (Exception NoSuchElementException) {
                System.out.println("¡¡¡Error!!! Debes de introducir un número real");
                sc.nextLine();
            }
        } while (true);
    }

    public static double leerRealLargo() {return 1;}
	
    /**
     * Leer real largo.
     *
     * @param mensaje el mensaje
     * @return Devuelve un real largo
     */
    public static double leerRealLargo(String mensaje) {
        Scanner sc = new Scanner(System.in);
        do {
            try {
                escribir(mensaje);
                return sc.nextDouble();
            } catch (Exception NoSuchElementException) {
                System.out.println("¡¡¡Error!!! Debes de introducir un número real largo");
                sc.nextLine();
            }
        } while (true);
    }

    public static String leerCadena() {return "";}
	
    /**
     * Leer cadena.
     *
     * @param mensaje el mensaje
     * @return Devuelve una cadena
     */
    public static String leerCadena(String mensaje) {
        Scanner sc = new Scanner(System.in);
        do {
            try {
                escribir(mensaje);
                return sc.next();
            } catch (Exception InputMismatchException) {
                System.out.println("¡¡¡Error!!! Debes de introducir una cadena");
                sc.nextLine();
            }
        } while (true);
    }

    public static char leerCaracter() {return ' ';}
	
    /**
     * Leer caracter.
     *
     * @param mensaje el mensaje
     * @return Devuelve un caracter
     */
    public static char leerCaracter(String mensaje) {
        Scanner sc = new Scanner(System.in);
        do {
            try {
                escribir(mensaje);
                return sc.next().charAt(0);
            } catch (Exception InputMismatchException) {
                System.out.println("¡¡¡Error!!! Debes de introducir un carácter");
                sc.nextLine();
            }
        } while (true);
    }

    public static boolean leerBooleano() {return true;}
    
    /**
     * Leer booleano.
     *
     * @param mensaje el mensaje
     * @return Devuleve un booleano
     */
    public static boolean leerBooleano(String mensaje) {
        Scanner sc = new Scanner(System.in);
        do {
            try {
                escribir(mensaje);
                return sc.nextBoolean();
            } catch (Exception NoSuchElementException) {
                System.out.println("¡¡¡Error!!! Debes de introducir un booleano");
                sc.nextLine();
            }
        } while (true);
    }

    /**
     * Escribir.
     *
     * @param mensaje el mensaje
     */
    public static void escribir(String mensaje) {
        System.out.print(mensaje);
    }

    /**
     * Escribir ln.
     *
     * @param mensaje el mensaje
     */
    public static void escribirLn(String mensaje) {
        System.out.println(mensaje);
    }
/*
    public static void escribirArchivo(String contenido, String rutaArchivo) {
        PrintWriter pw;
        FileWriter fichero = null;
        try {
            fichero = new FileWriter(rutaArchivo);
            pw = new PrintWriter(fichero);
            pw.println(contenido);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fichero) {
                    fichero.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static String leerArchivo(File file) throws FileNotFoundException, IOException {
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferReader = new BufferedReader(fileReader);
        String linea;
        String contenido = "";
        while ((linea = bufferReader.readLine()) != null) {
            contenido = contenido + linea + "\n";
        }
        bufferReader.close();
        fileReader.close();
        return contenido;
    }*/
}
