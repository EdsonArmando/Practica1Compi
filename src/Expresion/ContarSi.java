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
import Entorno.Simbolo.EnumTipoDato;
import static views.Inicio.salidaConsola;

/**
 *
 * @author EG
 */
public class ContarSi extends Expresion {
    public Expresion expId;
    public Expresion expClave;
    public Expresion expValor;
    public TipoRelacional relacional;
    
    public ContarSi(Expresion expId, Expresion expClave, TipoRelacional relacional, Expresion expValor, int fila, int columna){
        this.expId = expId;
        this.expClave = expClave;
        this.expValor = expValor;
        this.relacional = relacional;
        this.fila = fila;
        this.columna = columna;
    }
    @Override
    public Expresion obtenerValor(Entorno ent) {
        Expresion resultadoArchivo = this.expId.obtenerValor(ent);
        Archivo arch = (Archivo)resultadoArchivo.valor;
        
        Expresion resultadoClave = this.expClave.obtenerValor(ent);
        String idClave = resultadoClave.valor.toString();
        
        Expresion resultadoValor = this.expValor.obtenerValor(ent);
        
        Expresion contarSi = arch.contarSi(idClave, relacional, resultadoValor);
        if(contarSi==null){
            salidaConsola.append("\nError Semantico no se puede sumar Cadenas:"+this.expClave.toString());
            return null;
        
        }
        return new Literal(EnumTipoDato.NUMERICO, Double.parseDouble(contarSi.valor.toString()));
    }

    @Override
    public EnumTipoDato getTipo() {
        return this.tipo;
    }
}