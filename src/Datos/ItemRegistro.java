/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

/**
 *
 * @author EG
 */
public class ItemRegistro {
     int fila, columna;
    Object valor;
    Archivo.TipoItemRegistro tipo;
    
    public ItemRegistro(Archivo.TipoItemRegistro tipo, Object valor, int fila, int columna){
        this.tipo = tipo;
        this.valor =valor;
        this.fila = fila;
        this.columna = columna;
    }
    
}
