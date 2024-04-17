/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3rayadiferente;

/**
 *
 * @author Usuario
 */
public class Jugador {
    private char simbolo;
    private String nombre;

    public Jugador(char simbolo, String nombre) {
        this.simbolo = simbolo;
        this.nombre = nombre;
    }

    public char getSimbolo() {
        return simbolo;
    }

    public String getNombre() {
        return nombre;
    }
}


