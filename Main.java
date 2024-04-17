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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("¡Tres en Raya!");

        System.out.println("¿Cuántos juegos deseas jugar?");
        int numJuegos = scanner.nextInt();
        scanner.nextLine(); // Consumir el carácter de nueva línea restante

        Juego[] juegos = new Juego[numJuegos];

        for (int i = 0; i < numJuegos; i++) {
            System.out.println("Juego " + (i + 1));
            int tamañoTablero = elegirTamañoTablero(scanner);
            juegos[i] = new Juego(tamañoTablero, scanner);
        }

        // Iniciar cada juego uno por uno
        for (int i = 0; i < juegos.length; i++) {
            Juego juegoActual = juegos[i];
            juegoActual.iniciarJuego();
        }
    }

    public static int elegirTamañoTablero(Scanner scanner) {
        int tamaño;
        do {
            System.out.println("Elige el tamaño del tablero (3 minimo):");
            tamaño = scanner.nextInt();
            scanner.nextLine(); // Consumir el carácter de nueva línea restante
        } while (tamaño < 3);
        return tamaño;
    }
}

// Iniciar cada juego uno por uno
       

    

    


