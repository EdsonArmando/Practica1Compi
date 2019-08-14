/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.util.LinkedList;

/**
 *
 * @author EG
 */
public class Registro {
     int fila = 0, columna = 0;
    LinkedList<ItemRegistro> elementos;
    boolean primero = false;
    public Registro(LinkedList<ItemRegistro> elementos, boolean primero, int fila, int columna){
         this.elementos = elementos;
         this.primero = primero;
         this.fila = fila;
         this.columna = columna;
     }
    public LinkedList getLista(){
        return this.elementos;
    }
}
