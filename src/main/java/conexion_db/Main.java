/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion_db;

import editar_tabla.Pieza;

/**
 *
 * @author nroda
 */
public class Main {
    public static void main(String[] args) {
        Pieza pieza = new Pieza("Pata Cuadrada", 15.35);
        System.out.println(pieza.delete());
        
    }
}
