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
public class Tablero {

    private char[][] tablero;
    private int tamaño;

    public Tablero(int tamaño) {
        this.tamaño = tamaño;
        this.tablero = new char[tamaño][tamaño];
        inicializarTablero();
    }

    public static int elegirTamañoTablero(Scanner scanner) {
        int tamaño;
        do {
            System.out.println("Elige el tamaño del tablero (3 minimo):");
            tamaño = scanner.nextInt();
            // Consumir el carácter de nueva línea restante
            scanner.nextLine();
        } while (tamaño < 3);
        return tamaño;
    }

    private void inicializarTablero() {
        for (int i = 0; i < tamaño; i++) {
            for (int j = 0; j < tamaño; j++) {
                tablero[i][j] = ' ';
            }
        }
    }

    public void mostrarTablero() {
        System.out.println("  0 1 2");
        System.out.println(" - - -");
        for (int i = 0; i < tamaño; i++) {
            System.out.print(i);
            for (int j = 0; j < tamaño; j++) {
                System.out.print(" | " + tablero[i][j]);
            }
            System.out.println();
        }
    }

    public boolean comprobarVictoria(char jugador) {
        // Comprobar filas
        for (int i = 0; i < tamaño; i++) {
            boolean filaCompleta = true;
            for (int j = 0; j < tamaño; j++) {
                if (tablero[i][j] != jugador) {
                    filaCompleta = false;
                }
            }
            if (filaCompleta) {
                return true;
            }
        }
        // Comprobar columnas
        for (int i = 0; i < tamaño; i++) {
            boolean columnaCompleta = true;
            for (int j = 0; j < tamaño; j++) {
                if (tablero[j][i] != jugador) {
                    columnaCompleta = false;
                }
            }
            if (columnaCompleta) {
                return true;
            }
        }
        // Comprobar diagonales
        for (int i = 0; i < tamaño - 2; i++) {
            for (int j = 0; j < tamaño - 2; j++) {
                if (tablero[i][j] != ' ' && tablero[i][j] == tablero[i + 1][j + 1] && tablero[i][j] == tablero[i + 2][j + 2]) {
                    return true;
                }
            }
        }
        // Comprobar diagonales inversas
        for (int i = 2; i < tamaño; i++) {
            for (int j = 0; j < tamaño - 2; j++) {
                if (tablero[i][j] != ' ' && tablero[i][j] == tablero[i - 1][j + 1] && tablero[i][j] == tablero[i - 2][j + 2]) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean realizarMovimiento(int fila, int columna, char jugador) {

        if (fila >= 0 && fila < tamaño && columna >= 0 && columna < tamaño && tablero[fila][columna] == ' ') {
            tablero[fila][columna] = jugador;
            return true;
        } else {
            return false;
        }
    }

    public int getTamaño() {
        return tamaño;
    }
}
