/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3rayadiferente;

import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class Juego {
    private Tablero tablero;
    private Jugador[] jugadores;
    private int jugadorActualIndex;
    private boolean juegoActivo;
    private int movimientosRealizados;
    private Scanner scanner;

    public Juego(int tamañoTablero, Scanner scanner) {
        this.tablero = new Tablero(tamañoTablero);
        this.jugadores = new Jugador[2];
        this.jugadorActualIndex = 0;
        this.juegoActivo = true;
        this.movimientosRealizados = 0;
        this.scanner = scanner;

        // Solicitamos los nombres de los jugadores
        System.out.println("Introduce el nombre del primer jugador:");
        String nombreJugador1 = scanner.nextLine();
        System.out.println("Introduce el nombre del segundo jugador:");
        String nombreJugador2 = scanner.nextLine();

        // Crear los jugadores
        this.jugadores[0] = new Jugador('X', nombreJugador1);
        this.jugadores[1] = new Jugador('O', nombreJugador2);
    }

    public void iniciarJuego() {
        System.out.println("¡Tres en Raya!");
        while (juegoActivo) {
            // Lógica del juego de Tres en Raya
            Jugador jugadorActual = jugadores[jugadorActualIndex];
            tablero.mostrarTablero();
            System.out.println("Jugador " + jugadorActual.getNombre() + ", elige una fila (0-" + (tablero.getTamaño() - 1) + "):");
            int fila = scanner.nextInt();
            System.out.println("Jugador " + jugadorActual.getNombre() + ", elige una columna (0-" + (tablero.getTamaño() - 1) + "):");
            int columna = scanner.nextInt();

            boolean movimientoValido = false;
            while (!movimientoValido) {
                if (tablero.realizarMovimiento(fila, columna, jugadorActual.getSimbolo())) {
                    movimientosRealizados++;
                    movimientoValido = true;
                    if (tablero.comprobarVictoria(jugadorActual.getSimbolo())) {
                        System.out.println("¡El jugador " + jugadorActual.getNombre() + " ha ganado en Tres en Raya!");
                        juegoActivo = false;
                    } else if (movimientosRealizados == tablero.getTamaño() * tablero.getTamaño()) {
                        System.out.println("¡Empate en Tres en Raya! No hay ganador.");
                        juegoActivo = false;
                    } else {
                        // Cambiar al siguiente jugador
                        jugadorActualIndex = (jugadorActualIndex + 1) % jugadores.length;
                    }
                } else {
                    System.out.println("Movimiento inválido. Intenta de nuevo.");
                    // Solicitar nuevamente la fila y columna
                    System.out.println("Jugador " + jugadorActual.getNombre() + ", elige una fila (0-" + (tablero.getTamaño() - 1) + "):");
                    fila = scanner.nextInt();
                    System.out.println("Jugador " + jugadorActual.getNombre() + ", elige una columna (0-" + (tablero.getTamaño() - 1) + "):");
                    columna = scanner.nextInt();
                }
            }
        }
    }
}
