/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tresenraya;

import java.io.Console;

/**
 *
 * @author Pc
 */
public class TresEnRaya {

    private static char[][] tablero = new char[3][3];
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int opcion = 0, celda, ganador;
        
        do{
            ganador = -1;
            opcion = ES.leerEntero("Menú 3 en raya: \n"
                    + "1. Jugador vs CPU \n"
                    + "2. Jugador 1 vs Jugador 2 \n"
                    + "0. Salir \n"
                    + "Introduzca una opción: ");
            switch(opcion){
                case 0:
                    ES.escribirLn("Gracias por jugar. ¡¡Hasta la próxima!!");
                    break;
                case 1:
                    reiniciarTablero();
                    
                     for(int i = 0; i < 5; i++){
                        pintarTablero();
                        // Player 1
                        colocarFicha("Jugador 1:", 'X');
                        // CPU
                        logicaCPU();

                        if(i >= 2 && (ganador = comprobarGanador()) != 0){
                            break;
                        }
                    }
                    
                    if(ganador == 0)
                        ES.escribirLn("\n¡Habéis empatado!\n");
                    else if(ganador != -1)
                        ES.escribirLn("\nEl ganador es el jugador " + String.valueOf(ganador) + "\n");
                    
                    break;
                case 2:
                    reiniciarTablero();
                    
                    for(int i = 0; i < 9; i++){
                        // limpiar pantalla
                        // Player 1
                        if(i%2 == 0)
                            colocarFicha("Jugador 1:", 'X');
                        // Player 2
                        else
                            colocarFicha("Jugador 2:", 'O');
                        
                        if(i >= 4 && (ganador = comprobarGanador()) != 0){
                            break;
                        }
                    }
                    
                    if(ganador == 0)
                        ES.escribirLn("\n¡Habéis empatado!\n");
                    else if(ganador != -1)
                        ES.escribirLn("\nEl ganador es el jugador " + String.valueOf(ganador) + "\n");   
                    
                    break;
                default:
                    ES.escribirLn("Opción no válida.\n");
                    break;
            }
        }while(opcion != 0);
    }
    
    private static void reiniciarTablero(){
        for (char[] tablero1 : tablero) {
            for (int i = 0; i < tablero1.length; i++) {
                tablero1[i] = ' ';
            }
        }
    }
    
    private static void colocarFicha(String nombreJugador, char ficha){
        do{
            ES.escribirLn(nombreJugador);
        }while(comprobarCelda(ES.leerEntero(1, 3, "Introduzca la fila: ")-1, ES.leerEntero(1, 3, "Introduzca la columna: ")-1, ficha, true));
    }
    
    private static int comprobarGanador(){
        // Comprobar filas
        for (char[] tablero1 : tablero) {
            if (tablero1[0] == tablero1[1] && tablero1[1] == tablero1[2]) {
                if (tablero1[0] == 'X') {
                    return 1;
                } else { 
                    return 2;
                }
            }
        }
        
        // Comprobar columnas
        for (int i = 0; i < tablero[0].length; i++) {
            if(tablero[0][i] == tablero[1][i] && tablero[1][i] == tablero[2][i]){
                if(tablero[0][i] == 'X')
                    return 1;
                else 
                    return 2;
            }
        }
        
        // Comprobar diagonales
        if(tablero[0][0] == tablero[1][1] && tablero[1][1] == tablero[2][2]){
            if(tablero[0][0] == 'X')
                return 1;
            else 
                return 2;
        }
        else if(tablero[2][0] == tablero[1][1] && tablero[1][1] == tablero[0][2]){
            if(tablero[0][0] == 'X')
                return 1;
            else 
                return 2;
        }        
        return 0;
    }
    
    private static void logicaCPU()
    {
        /*
        int fila, columna;
        
        do{
            fila = (int)(Math.random()*3);
            columna = (int)(Math.random()*3);
            ES.escribirLn("Fila: " + String.valueOf(fila+1) + " Columna: " + String.valueOf(columna+1));
        }while(comprobarCelda(fila, columna, 'O', false));
        */
                  
        while(comprobarCelda((int)(Math.random()*3), (int)(Math.random()*3), 'O', false));
    }
    
    private static boolean comprobarCelda(int fila, int columna, char simbolo, boolean mostrarMensajes){
        if(tablero[fila][columna] == ' '){
            tablero[fila][columna] = simbolo;            
            return false;
        }
        else if(mostrarMensajes)
            ES.escribirLn("Error. La celda está ocupada");
        
        return true;
    }
    
    private static void pintarTablero(){
        //System.out.print("\033[H\033[2J");
        ES.escribirLn("\n-------------");
        for(int i = 0; i < tablero.length; i++){
            for(int j = 0; j < tablero[i].length; j++)
                ES.escribir("| " + tablero[i][j] + " ");
            ES.escribirLn("|");
            ES.escribirLn("-------------");
        }
        ES.escribirLn("");
    }
}
