/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Expresion;

import Entorno.Entorno;
import Entorno.Simbolo;
import Entorno.Simbolo.EnumTipoDato;

/**
 *
 * @author EG
 */
public class Literal extends Expresion{
    
       /**
     * @param tipo Tipo del literal (Numerico, Cadena)
     * @param valor valor del literal
     */
    public Literal(Simbolo.EnumTipoDato tipo, Object valor) {
        this.tipo = tipo;
        this.valor = valor;
    }

    @Override
    public Expresion obtenerValor(Entorno ent) {
        return this; //Retorno la instancia del objeto Expresion
    }

    @Override
    public Simbolo.EnumTipoDato getTipo() {
        return this.tipo;
    }
}
