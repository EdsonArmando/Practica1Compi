/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Expresion;

import Datos.Archivo;
import Entorno.Entorno;
import Entorno.Simbolo;
import Entorno.Simbolo.EnumTipoDato;

/**
 *
 * @author EG
 */
public class Sumar extends Expresion{
    String id;
    String ident;
    Expresion clave;
    Expresion identificador;
    public Sumar(Expresion identificador, Expresion clave,int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
        this.identificador = identificador;
        this.clave = clave;
        
    }
    @Override
    public Expresion obtenerValor(Entorno ent) {
        Expresion resultadoArchivo = this.identificador.obtenerValor(ent);
        Archivo arch = (Archivo)resultadoArchivo.valor;
        
        Expresion resultadoClave = this.clave.obtenerValor(ent);
        String idClave = resultadoClave.valor.toString();
        
        Expresion suma = arch.sumar(idClave);
        return new Literal(EnumTipoDato.NUMERICO, Double.parseDouble(suma.valor.toString()));
    }

    @Override
    public Simbolo.EnumTipoDato getTipo() {
        return this.tipo;
    }
}
