/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Instruccion;


import Entorno.Entorno;
import Entorno.Simbolo;
import Entorno.Simbolo.EnumTipoDato;
import Expresion.Expresion;
import Expresion.Id;
import java.util.LinkedList;
import static views.Inicio.salidaConsola;

/**
 *
 * @author EG
 */
public class Imprimir extends Instruccion{
    LinkedList<Expresion> expresiones;
    Expresion expresion;
    Id id;
    public Imprimir(LinkedList<Expresion> expresiones, int fila, int columna) {
        this.expresiones = expresiones;
        this.fila = fila;
        this.columna = columna;
    }
    
    
    @Override
    public void ejecutar(Entorno ent) {
        System.out.println("Ejecutando la instrucción Imprimir");
        String salida = "";
        for (int i = 0; i < this.expresiones.size(); i++) {
         Expresion resultado = this.expresiones.get(i).obtenerValor(ent);
            if(resultado.getTipo() == EnumTipoDato.ERROR){
                System.out.println("La expresion es un error :(");
                return;
            }else{
                salida += resultado.valor.toString();
            }
        }
        System.out.println(salida);
        salidaConsola.append(salida+"\n");
    }

    @Override
    public Instruccion.EnumTipoIns getTipo() {
        return this.tipo;
    }
    
}

