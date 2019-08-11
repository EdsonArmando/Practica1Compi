/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Instruccion;

import Entorno.Entorno;

/**
 *
 * @author EG
 */
public class InstruccionConError extends Instruccion{
    String causa;
    
    public InstruccionConError(String causa, int fila, int columna){
        this.causa = causa;
        this.fila = fila;
        this.columna = columna;
    }
    @Override
    public void ejecutar(Entorno ent) {
        System.out.println("ERROR::"+this.causa+" Encontrado en fila:"+this.fila+", columna:"+this.columna);
    }

    @Override
    public Instruccion.EnumTipoIns getTipo() {
        return this.tipo;
    }
    
}
