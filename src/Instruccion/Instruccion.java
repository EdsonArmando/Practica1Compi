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
public abstract class Instruccion {
    int fila, columna;
    public EnumTipoIns tipo;
    public abstract void ejecutar(Entorno ent);
    public abstract EnumTipoIns getTipo();
    
    public enum EnumTipoIns{
       DECLARACION,
       IMPRIMIR,
       LEERARCHIVO,
       GRAFICAR
    }            
}

