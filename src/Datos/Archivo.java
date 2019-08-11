/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Expresion.Expresion;
import java.util.LinkedList;

/**
 *
 * @author EG
 */
public class Archivo {
    int fila, columna;
    LinkedList<Registro> listaRegistros;
    
    public Archivo(LinkedList<Registro> listaRegistros, int fila, int columna){
        this.listaRegistros = listaRegistros;
        this.fila = fila;
        this.columna = columna;
    }
    
    public int contar(){
       return listaRegistros.size();
    }
    
    public Expresion sumar(){
        return null;
    }
    
    public enum TipoItemRegistro{
        CADENA,
        NUMERO
    }
}
