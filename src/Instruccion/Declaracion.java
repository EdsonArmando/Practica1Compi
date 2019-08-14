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
public class Declaracion extends Instruccion{
    Simbolo.EnumTipoDato tipoVariable;
    String nombreVariable;
    Expresion expresion;

    /**
     * @param tipo Tipo de la variable que se quiere declarar
     * @param nombre Nombre de la variable que se quiere declarar
     * @param expresion Expresión que se le quiere asignar a la variable
     * @param fila La fila donde se encuentra declarada la instruccion
     * @param columna La columna donde se encuentra delcarada la instruccion
     */
    public Declaracion(Simbolo.EnumTipoDato tipo, String nombre, Expresion expresion, int fila, int columna) {
        this.tipoVariable = tipo;
        this.nombreVariable = nombre;
        this.expresion = expresion;
        this.fila = fila;
        this.columna = columna;
    }
    
    @Override
    public void ejecutar(Entorno ent) {
        Expresion resultado = expresion.obtenerValor(ent); //Resuelvo la expresión que le quiero asignar a la variable
        ent.insertar(this.nombreVariable, new Simbolo(this.tipoVariable, resultado.valor)); // Guardo la variable
        
        System.out.println("Ejecutando la instrucción Declaración --> TipoDato: " + 
                this.tipoVariable.toString() + ", Nombre variable: " + this.nombreVariable + ", Valor: " + resultado.valor);
        salidaConsola.append(this.nombreVariable);
    }

    @Override
    public Instruccion.EnumTipoIns getTipo() {
        return this.tipo;
    }
}

