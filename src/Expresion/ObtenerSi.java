/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Expresion;

import Datos.Archivo;
import Datos.Archivo.TipoRelacional;
import Entorno.Entorno;
import Entorno.Simbolo;

/**
 *
 * @author EG
 */
public class ObtenerSi extends Expresion {
    Expresion identificador;
    Expresion clave;
    TipoRelacional operador;
    Expresion valor;
    public ObtenerSi(Expresion identificador, Expresion clave, TipoRelacional operador, Expresion valor, int fila, int columna){
        this.identificador = identificador;
        this.clave = clave;
        this.operador = operador;
        this.valor = valor;
        this.fila = fila;
        this.columna = columna;
    }
    @Override
    public Expresion obtenerValor(Entorno ent) {
        Expresion id=this.clave.obtenerValor(ent);
        Expresion resultado = this.identificador.obtenerValor(ent);
        Expresion val = this.valor.obtenerValor(ent);
        Archivo ar = (Archivo)resultado.valor;
        
        Expresion variable = ar.ObtenerSi(String.valueOf(id.valor), operador, String.valueOf(val.valor));
        return new Literal(Simbolo.EnumTipoDato.CADENA,String.valueOf(variable.valor));
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Simbolo.EnumTipoDato getTipo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
