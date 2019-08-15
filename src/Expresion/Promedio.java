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
public class Promedio extends Expresion{
    Expresion identificador;
    Expresion clave;
    
    public Promedio(Expresion identificador, Expresion clave, int fila, int columna){
        this.identificador = identificador;
        this.clave = clave;
        this.fila = fila;
        this.columna = columna;                
    }
    @Override
    public Expresion obtenerValor(Entorno ent) {
      Expresion result = this.identificador.obtenerValor(ent);
      Archivo arc=(Archivo)result.valor;
            
     Expresion resolVariable=arc.Promedio(String.valueOf(clave.valor));
     
     return new Literal(EnumTipoDato.NUMERICO,Double.parseDouble(resolVariable.valor.toString()));
    }

    @Override
    public Simbolo.EnumTipoDato getTipo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
