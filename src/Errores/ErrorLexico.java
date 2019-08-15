/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Errores;

import java.io.PrintWriter;

/**
 *
 * @author EG
 */
public class ErrorLexico {
    public String lexema;
    public int fila;
    public int columna;
  
    public ErrorLexico(String lexema, int fila, int columna){
        this.lexema=lexema;
        this.fila=fila;
        this.columna = columna;
    }
    
}
