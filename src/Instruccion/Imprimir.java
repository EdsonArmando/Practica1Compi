/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Instruccion;


import Entorno.Entorno;
import Entorno.Simbolo;
import Expresion.Expresion;
import static views.Inicio.salidaConsola;

/**
 *
 * @author EG
 */
public class Imprimir extends Instruccion{
    Expresion expresion;
    
    public Imprimir(Expresion expresion, int fila, int columna) {
        this.expresion = expresion;
        this.fila = fila;
        this.columna = columna;
    }
    
    @Override
    public void ejecutar(Entorno ent) {
        System.out.println("Ejecutando la instrucción Imprimir");
        Expresion resultado = this.expresion.obtenerValor(ent);
        if(resultado.getTipo() == Simbolo.EnumTipoDato.ERROR){
            System.out.println("La expresion es un error :(");
            return;
        }
        System.out.println(String.valueOf(resultado.valor));
        salidaConsola.append(String.valueOf(resultado.valor));
    }

    @Override
    public Instruccion.EnumTipoIns getTipo() {
        return this.tipo;
    }
    
}

